package com.baidu.tieba.ala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.aq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final int hBC = "   ".length();
    private PersonCardActivity hBD;
    private TextView hBE;
    private TextView hBF;
    private TextView hBG;
    private View hBH;
    private List<AlaLiveMarkData> hBI;
    private List<AlaLiveMarkData> hBJ;
    private List<AlaLiveMarkData> hBK;
    private aq hmr;
    private View mContentView;
    private View mRootView;
    private int hBL = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.hBD = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hBE = (TextView) this.mContentView.findViewById(a.f.user_mark_normal);
            this.hBF = (TextView) this.mContentView.findViewById(a.f.user_mark_extra);
            this.hBG = (TextView) this.mRootView.findViewById(a.f.user_name);
            this.hBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ciL();
                }
            });
            this.hBH = this.mContentView.findViewById(a.f.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void ciL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hmr != null && com.baidu.live.aa.a.Ph().bsh.aNV != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hmr.user_id)) {
                    String str = com.baidu.live.aa.a.Ph().bsh.aNV.aNH;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.hBD.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.aa.a.Ph().bsh.aNV.aNI;
                    if (str2 != null && this.hmr != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hmr.user_id;
                        String str4 = this.hmr.portrait;
                        String str5 = this.hmr.user_nickname;
                        StringBuilder sb = new StringBuilder();
                        sb.append("id=");
                        sb.append(ExtraParamsManager.getEncryptionUserId(str3));
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("portrait=");
                        try {
                            sb.append(URLEncoder.encode(str4, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("nickname=");
                        try {
                            sb.append(URLEncoder.encode(str5, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!str2.contains("?")) {
                            sb.insert(0, "?");
                        } else {
                            sb.insert(0, ETAG.ITEM_SEPARATOR);
                        }
                        sb.insert(0, str2);
                        String sb2 = sb.toString();
                        this.hBD.finish();
                        if (!TextUtils.isEmpty(sb2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, sb2));
                        }
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
            }
        }
    }

    public void setData(aq aqVar) {
        if (aqVar != null) {
            this.hmr = aqVar;
            if (this.hBI == null) {
                this.hBI = new ArrayList();
            }
            this.hBI.clear();
            if (this.hBJ == null) {
                this.hBJ = new ArrayList();
            }
            this.hBJ.clear();
            if (this.hBK == null) {
                this.hBK = new ArrayList();
            }
            this.hBK.clear();
            boolean cD = cD(aqVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hBI)) {
                a("", "", this.hBE, this.hBI);
            }
            if (!ListUtils.isEmpty(this.hBJ) || cD) {
                int i = aqVar.aMu;
                if (i <= 0) {
                    i = this.hBL;
                }
                a("  ", i + this.hBD.getResources().getString(a.h.ala_count_mei), this.hBF, this.hBJ);
                this.hBF.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_person_card_more, 0);
                this.hBH.setVisibility(0);
            } else {
                this.hBF.setText("");
                this.hBF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hBH.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hBK)) {
                a(ciM() + " ", "", this.hBG, this.hBK);
            }
        }
    }

    private String ciM() {
        String nameShow = this.hmr.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                return TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            return nameShow;
        }
        return "";
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = str + "   ";
            }
        }
        String str3 = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(str3);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (this.hmr != null) {
                    alaLiveMarkData.userLevel = this.hmr.level_id;
                    alaLiveMarkData.setupNewLevelMark();
                }
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hBC * i3);
                    final int i5 = i4 + 1;
                    AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                    alaLiveMarkData2.mark_pic = alaLiveMarkData.mark_pic;
                    alaLiveMarkData2.isWidthAutoFit = true;
                    new com.baidu.live.view.b(this.hBD, alaLiveMarkData2, true, new b.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar, Bitmap bitmap) {
                            spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                            textView.setText(spannableStringBuilder);
                        }
                    });
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private boolean cD(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.hBD.cit())) {
                    linkedList.add(alaLiveMarkData);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return false;
        }
        boolean z = false;
        for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
            if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                this.hBJ.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hBK.add(alaLiveMarkData2);
            } else {
                this.hBI.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hBL = this.hBJ.size();
        if (this.hBL > 2) {
            this.hBJ = this.hBJ.subList(0, 2);
        }
        if (this.hBI.size() > 3) {
            this.hBI = this.hBI.subList(0, 3);
        }
        return z;
    }
}
