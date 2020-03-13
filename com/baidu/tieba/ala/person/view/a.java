package com.baidu.tieba.ala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.u.a;
import com.baidu.live.view.c;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final int fsC = "   ".length();
    private x ffj;
    private PersonCardActivity fsD;
    private TextView fsE;
    private TextView fsF;
    private TextView fsG;
    private View fsH;
    private List<AlaLiveMarkData> fsI;
    private List<AlaLiveMarkData> fsJ;
    private List<AlaLiveMarkData> fsK;
    private int fsL = 0;
    private long lastClickTime = 0;
    private View mContentView;
    private View mRootView;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.fsD = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.fsE = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.fsF = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.fsG = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.fsF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bsd();
                }
            });
            this.fsH = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bsd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.ffj != null && com.baidu.live.v.a.zl().axD.adb != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.ffj.user_id)) {
                    String str = com.baidu.live.v.a.zl().axD.adb.acN;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.fsD.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.v.a.zl().axD.adb.acO;
                    if (str2 != null && this.ffj != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.ffj.user_id;
                        String str4 = this.ffj.portrait;
                        String str5 = this.ffj.user_nickname;
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
                        this.fsD.finish();
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

    public void setData(x xVar) {
        if (xVar != null) {
            this.ffj = xVar;
            if (this.fsI == null) {
                this.fsI = new ArrayList();
            }
            this.fsI.clear();
            if (this.fsJ == null) {
                this.fsJ = new ArrayList();
            }
            this.fsJ.clear();
            if (this.fsK == null) {
                this.fsK = new ArrayList();
            }
            this.fsK.clear();
            bG(xVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.fsI)) {
                a("", "", this.fsE, this.fsI);
            }
            if (!ListUtils.isEmpty(this.fsJ)) {
                int i = xVar.abm;
                if (i <= 0) {
                    i = this.fsL;
                }
                a("  ", i + this.fsD.getResources().getString(a.i.ala_count_mei), this.fsF, this.fsJ);
                this.fsF.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.fsH.setVisibility(0);
            } else {
                this.fsF.setText("");
                this.fsF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.fsH.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.fsK)) {
                a(this.ffj.getNameShow() + HanziToPinyin.Token.SEPARATOR, "", this.fsG, this.fsK);
            }
        }
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        for (int i = 0; i < list.size(); i++) {
            str = str + "   ";
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (alaLiveMarkData != null) {
                    final int i4 = length + (fsC * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.fsD, alaLiveMarkData, this.ffj.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    } else {
                        new com.baidu.live.view.c(this.fsD, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void bG(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.fsD.brN())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
                    if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                        this.fsJ.add(alaLiveMarkData2);
                    } else if (alaLiveMarkData2.type == 2) {
                        this.fsK.add(alaLiveMarkData2);
                    } else {
                        this.fsI.add(alaLiveMarkData2);
                    }
                }
                this.fsL = this.fsJ.size();
                if (this.fsL > 2) {
                    this.fsJ = this.fsJ.subList(0, 2);
                }
                if (this.fsI.size() > 3) {
                    this.fsI = this.fsI.subList(0, 3);
                }
            }
        }
    }
}
