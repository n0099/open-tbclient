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
import com.baidu.live.data.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
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
    private static final int fXw = "   ".length();
    private z fJQ;
    private TextView fXA;
    private View fXB;
    private List<AlaLiveMarkData> fXC;
    private List<AlaLiveMarkData> fXD;
    private List<AlaLiveMarkData> fXE;
    private PersonCardActivity fXx;
    private TextView fXy;
    private TextView fXz;
    private View mContentView;
    private View mRootView;
    private int fXF = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.fXx = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.fXy = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.fXz = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.fXA = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.fXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bBN();
                }
            });
            this.fXB = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.ala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bBN() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.fJQ != null && com.baidu.live.v.a.Eo().aRw.avD != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.fJQ.user_id)) {
                    String str = com.baidu.live.v.a.Eo().aRw.avD.avp;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.fXx.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.v.a.Eo().aRw.avD.avq;
                    if (str2 != null && this.fJQ != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.fJQ.user_id;
                        String str4 = this.fJQ.portrait;
                        String str5 = this.fJQ.user_nickname;
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
                        this.fXx.finish();
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

    public void setData(z zVar) {
        if (zVar != null) {
            this.fJQ = zVar;
            if (this.fXC == null) {
                this.fXC = new ArrayList();
            }
            this.fXC.clear();
            if (this.fXD == null) {
                this.fXD = new ArrayList();
            }
            this.fXD.clear();
            if (this.fXE == null) {
                this.fXE = new ArrayList();
            }
            this.fXE.clear();
            bP(zVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.fXC)) {
                a("", "", this.fXy, this.fXC);
            }
            if (!ListUtils.isEmpty(this.fXD)) {
                int i = zVar.atQ;
                if (i <= 0) {
                    i = this.fXF;
                }
                a("  ", i + this.fXx.getResources().getString(a.i.ala_count_mei), this.fXz, this.fXD);
                this.fXz.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.fXB.setVisibility(0);
            } else {
                this.fXz.setText("");
                this.fXz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.fXB.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.fXE)) {
                a(bBO() + " ", "", this.fXA, this.fXE);
            }
        }
    }

    private String bBO() {
        String nameShow = this.fJQ.getNameShow();
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
                    final int i4 = length + (fXw * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.fXx, alaLiveMarkData, this.fJQ.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    } else {
                        new com.baidu.live.view.c(this.fXx, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.3
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
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

    private void bP(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.fXx.bBv())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
                    if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                        this.fXD.add(alaLiveMarkData2);
                    } else if (alaLiveMarkData2.type == 2) {
                        this.fXE.add(alaLiveMarkData2);
                    } else {
                        this.fXC.add(alaLiveMarkData2);
                    }
                }
                this.fXF = this.fXD.size();
                if (this.fXF > 2) {
                    this.fXD = this.fXD.subList(0, 2);
                }
                if (this.fXC.size() > 3) {
                    this.fXC = this.fXC.subList(0, 3);
                }
            }
        }
    }
}
