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
    private static final int evf = "   ".length();
    private s eiX;
    private PersonCardActivity evg;
    private TextView evh;
    private TextView evi;
    private List<AlaLiveMarkData> evj;
    private List<AlaLiveMarkData> evk;
    private View mContentView;

    public a(PersonCardActivity personCardActivity, View view) {
        this.evg = personCardActivity;
        this.mContentView = view;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.evh = (TextView) this.mContentView.findViewById(a.g.user_mark_line_1);
            this.evi = (TextView) this.mContentView.findViewById(a.g.user_mark_line_2);
            this.evi.setVisibility(8);
        }
    }

    public void setData(s sVar) {
        if (sVar != null) {
            this.eiX = sVar;
            if (this.evj == null) {
                this.evj = new ArrayList();
            }
            this.evj.clear();
            if (this.evk == null) {
                this.evk = new ArrayList();
            }
            this.evk.clear();
            bH(sVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.evj)) {
                a(this.evh, this.evj);
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
                    final int i4 = i3 * evf;
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new com.baidu.live.view.b(this.evg, alaLiveMarkData, this.eiX.level_id, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.1
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
                        new com.baidu.live.view.c(this.evg, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.ala.person.view.a.2
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.evg.aXg())) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            if (!ListUtils.isEmpty(linkedList)) {
                if (linkedList.size() >= 6) {
                    this.evj = linkedList.subList(0, 6);
                } else {
                    this.evj.addAll(linkedList);
                }
            }
        }
    }
}
