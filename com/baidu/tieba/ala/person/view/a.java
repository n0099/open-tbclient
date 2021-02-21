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
import com.baidu.live.data.ax;
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
/* loaded from: classes11.dex */
public class a {
    private static final int hXx = "   ".length();
    private ax hHL;
    private TextView hXA;
    private TextView hXB;
    private View hXC;
    private List<AlaLiveMarkData> hXD;
    private List<AlaLiveMarkData> hXE;
    private List<AlaLiveMarkData> hXF;
    private PersonCardActivity hXy;
    private TextView hXz;
    private View mContentView;
    private View mRootView;
    private int hXG = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.hXy = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hXz = (TextView) this.mContentView.findViewById(a.f.user_mark_normal);
            this.hXA = (TextView) this.mContentView.findViewById(a.f.user_mark_extra);
            this.hXB = (TextView) this.mRootView.findViewById(a.f.user_name);
            this.hXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cmM();
                }
            });
            this.hXC = this.mContentView.findViewById(a.f.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cmM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hHL != null && com.baidu.live.ae.a.Qj().bAS.aPV != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hHL.user_id)) {
                    String str = com.baidu.live.ae.a.Qj().bAS.aPV.aPH;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.hXy.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.ae.a.Qj().bAS.aPV.aPI;
                    if (str2 != null && this.hHL != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hHL.user_id;
                        String str4 = this.hHL.portrait;
                        String str5 = this.hHL.user_nickname;
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
                        this.hXy.finish();
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

    public void setData(ax axVar) {
        if (axVar != null) {
            this.hHL = axVar;
            if (this.hXD == null) {
                this.hXD = new ArrayList();
            }
            this.hXD.clear();
            if (this.hXE == null) {
                this.hXE = new ArrayList();
            }
            this.hXE.clear();
            if (this.hXF == null) {
                this.hXF = new ArrayList();
            }
            this.hXF.clear();
            boolean cJ = cJ(axVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hXD)) {
                a("", "", this.hXz, this.hXD);
            }
            if (!ListUtils.isEmpty(this.hXE) || cJ) {
                int i = axVar.aOs;
                if (i <= 0) {
                    i = this.hXG;
                }
                a("  ", i + this.hXy.getResources().getString(a.h.ala_count_mei), this.hXA, this.hXE);
                this.hXA.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_person_card_more, 0);
                this.hXC.setVisibility(0);
            } else {
                this.hXA.setText("");
                this.hXA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hXC.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hXF)) {
                a(cmN() + " ", "", this.hXB, this.hXF);
            }
        }
    }

    private String cmN() {
        String nameShow = this.hHL.getNameShow();
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
        CharSequence charSequence = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(charSequence);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (this.hHL != null) {
                    alaLiveMarkData.userLevel = this.hHL.level_id;
                    alaLiveMarkData.setupNewLevelMark();
                }
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hXx * i3);
                    final int i5 = i4 + 1;
                    if (alaLiveMarkData.isGuardType()) {
                        Bitmap a2 = com.baidu.live.aj.b.a(this.hXy, alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds34, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            spannableStringBuilder.setSpan(new com.baidu.live.view.b(this.hXy, a2), i4, i5, 17);
                            textView.setText(spannableStringBuilder);
                        }
                    } else {
                        AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                        alaLiveMarkData2.mark_pic = alaLiveMarkData.mark_pic;
                        alaLiveMarkData2.isWidthAutoFit = true;
                        new com.baidu.live.view.b(this.hXy, alaLiveMarkData2, true, new b.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(bVar, i4, i5, 17);
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

    private boolean cJ(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.hXy.cmt())) {
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
                this.hXE.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hXF.add(alaLiveMarkData2);
            } else {
                this.hXD.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hXG = this.hXE.size();
        if (this.hXG > 2) {
            this.hXE = this.hXE.subList(0, 2);
        }
        if (this.hXD.size() > 3) {
            this.hXD = this.hXD.subList(0, 3);
        }
        return z;
    }
}
