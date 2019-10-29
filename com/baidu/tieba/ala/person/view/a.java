package com.baidu.tieba.ala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.s;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.c;
import com.baidu.tieba.ala.person.PersonCardActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static final int evW = "   ".length();
    private s ejO;
    private PersonCardActivity evX;
    private TextView evY;
    private TextView evZ;
    private List<AlaLiveMarkData> ewa;
    private List<AlaLiveMarkData> ewb;
    private View mContentView;

    public a(PersonCardActivity personCardActivity, View view) {
        this.evX = personCardActivity;
        this.mContentView = view;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.evY = (TextView) this.mContentView.findViewById(a.g.user_mark_line_1);
            this.evZ = (TextView) this.mContentView.findViewById(a.g.user_mark_line_2);
            this.evZ.setVisibility(8);
        }
    }

    public void setData(s sVar) {
        if (sVar != null) {
            this.ejO = sVar;
            if (this.ewa == null) {
                this.ewa = new ArrayList();
            }
            this.ewa.clear();
            if (this.ewb == null) {
                this.ewb = new ArrayList();
            }
            this.ewb.clear();
            bH(sVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.ewa)) {
                a(this.evY, this.ewa);
            }
        }
    }

    private void a(final TextView textView, List<AlaLiveMarkData> list) {
        int i = 0;
        String str = "";
        int i2 = 0;
        while (i2 < list.size()) {
            i2++;
            str = "   " + str;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (true) {
            int i3 = i;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (alaLiveMarkData != null) {
                    final int i4 = i3 * evW;
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.evX, alaLiveMarkData, this.ejO.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.1
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
                        new com.baidu.live.view.c(this.evX, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
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
                i = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void bH(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.evX.aXi())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                if (linkedList.size() >= 6) {
                    this.ewa = linkedList.subList(0, 6);
                } else {
                    this.ewa.addAll(linkedList);
                }
            }
        }
    }
}
