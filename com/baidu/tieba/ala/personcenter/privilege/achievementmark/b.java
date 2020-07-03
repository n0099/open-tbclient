package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> dPv;
    private a gCH;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.dPv = null;
        this.dPv = tbPageContext;
        this.gCH = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.list == null || i >= this.list.size()) {
            return null;
        }
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0595b c0595b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0595b c0595b2 = new C0595b();
            c0595b2.gCK = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0595b2.gCL = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0595b2.gCM = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0595b2.gCN = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0595b2.gCO = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0595b2.gCP = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0595b2.gCQ = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0595b2.gCR = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0595b2.gCS = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0595b2.gCT = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0595b2.gCU = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0595b2.gCV = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0595b2.gCW = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0595b2.gCX = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0595b2.gCY = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0595b2.gCZ = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0595b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0595b = c0595b2;
        } else {
            c0595b = (C0595b) view.getTag();
        }
        a(c0595b);
        if (aVar != null) {
            if (aVar.sl(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sl = aVar.sl(0);
                c0595b.gCN.setVisibility(0);
                c0595b.gCK.setText(sl.bLF() == null ? "" : sl.bLF());
                if (sl.bLG() != null) {
                    c0595b.gCL.setDefaultBgResource(R.color.transparent);
                    c0595b.gCL.startLoad(sl.bLG(), 10, false);
                }
                c(c0595b.gCM, sl.bLH());
                c(c0595b.gCL, sl.bLH());
                a(c0595b.gCO, sl.bLL(), sl.price);
                c0595b.gCN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gCH != null) {
                            b.this.gCH.a(aVar.sl(0));
                        }
                    }
                });
            } else {
                c0595b.gCN.setVisibility(4);
                c0595b.gCN.setOnClickListener(null);
            }
            if (aVar.sl(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sl2 = aVar.sl(1);
                c0595b.gCS.setVisibility(0);
                c0595b.gCP.setText(sl2.bLF() == null ? "" : sl2.bLF());
                if (sl2.bLG() != null) {
                    c0595b.gCQ.setDefaultBgResource(R.color.transparent);
                    c0595b.gCQ.startLoad(sl2.bLG(), 10, false);
                }
                c(c0595b.gCR, sl2.bLH());
                c(c0595b.gCQ, sl2.bLH());
                a(c0595b.gCT, sl2.bLL(), sl2.price);
                c0595b.gCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gCH != null) {
                            b.this.gCH.a(aVar.sl(1));
                        }
                    }
                });
            } else {
                c0595b.gCS.setVisibility(4);
                c0595b.gCS.setOnClickListener(null);
            }
            if (aVar.sl(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sl3 = aVar.sl(2);
                c0595b.gCX.setVisibility(0);
                c0595b.gCU.setText(sl3.bLF() == null ? "" : sl3.bLF());
                if (sl3.bLG() != null) {
                    c0595b.gCV.setDefaultBgResource(R.color.transparent);
                    c0595b.gCV.startLoad(sl3.bLG(), 10, false);
                }
                c(c0595b.gCW, sl3.bLH());
                c(c0595b.gCV, sl3.bLH());
                a(c0595b.gCY, sl3.bLL(), sl3.price);
                c0595b.gCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gCH != null) {
                            b.this.gCH.a(aVar.sl(2));
                        }
                    }
                });
            } else {
                c0595b.gCX.setVisibility(4);
                c0595b.gCX.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0595b.gCZ.setVisibility(0);
            } else {
                c0595b.gCZ.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bLB() != null) {
                c0595b.title.setVisibility(0);
                c0595b.title.setText(aVar.bLB());
            } else {
                c0595b.title.setVisibility(8);
            }
        }
        view.setTag(c0595b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.dPv.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou(j));
            return;
        }
        textView.setVisibility(8);
    }

    private void c(TbImageView tbImageView, int i) {
        if (tbImageView != null) {
            if (i == 0) {
                tbImageView.setAlpha(0.5f);
            } else if (i == 3) {
                tbImageView.setAlpha(0.2f);
            } else {
                tbImageView.setAlpha(1);
            }
        }
    }

    private void a(C0595b c0595b) {
        if (c0595b != null) {
            an.setViewTextColor(c0595b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCK, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCP, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCU, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCO, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCT, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            an.setViewTextColor(c0595b.gCY, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0595b.gCL.setDefaultResource(R.drawable.pic_live_honor_1);
                c0595b.gCL.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0595b.gCQ.setDefaultResource(R.drawable.pic_live_honor_1);
                c0595b.gCQ.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0595b.gCV.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0595b.gCL.setDefaultResource(R.drawable.pic_live_honor);
                c0595b.gCL.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0595b.gCQ.setDefaultResource(R.drawable.pic_live_honor);
                c0595b.gCQ.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0595b.gCV.setDefaultResource(R.drawable.pic_live_honor);
            }
            an.setBackgroundColor(c0595b.gCZ, R.color.cp_bg_line_c);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                an.setViewTextColor(textView, (int) R.color.cp_cont_d);
                an.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                an.setViewTextColor(textView, (int) R.color.live_cp_other_b);
                an.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                an.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                an.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                an.setViewTextColor(textView, (int) R.color.cp_cont_d);
                an.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    public void setData(List<c> list) {
        if (list != null) {
            if (this.list != null && this.list.size() > 0) {
                this.list.clear();
            }
            this.list = bY(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bY(List<c> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                break;
            }
            List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b> list2 = list.get(i3).getList();
            int size = list2.size();
            if (size % 3 == 0) {
                i = size / 3;
            } else {
                i = (size / 3) + 1;
            }
            com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][] bVarArr = (com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) Array.newInstance(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b.class, i, 3);
            for (int i4 = 0; i4 < size; i4++) {
                bVarArr[i4 / 3][i4 % 3] = list2.get(i4);
                bVarArr[i4 / 3][i4 % 3].Dz(list.get(i3).bLB());
            }
            arrayList2.add(bVarArr);
            i2 = i3 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= arrayList2.size()) {
                return arrayList;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < ((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length) {
                    com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = new com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a();
                    if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length == 1) {
                        aVar.setType(1);
                    } else if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length > 1 && i8 == 0) {
                        aVar.setType(2);
                    } else if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length > 1 && i8 == ((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6)).length - 1) {
                        aVar.setType(3);
                    } else {
                        aVar.setType(4);
                    }
                    if (i6 == arrayList2.size() - 1) {
                        if (aVar.getType() == 1) {
                            aVar.setType(2);
                        } else if (aVar.getType() == 3) {
                            aVar.setType(4);
                        }
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= 3) {
                            break;
                        }
                        if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[i8][i10] != null) {
                            aVar.b(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[i8][i10]);
                        }
                        i9 = i10 + 1;
                    }
                    if (((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0] != null) {
                        aVar.Dz(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bLB());
                    }
                    arrayList.add(aVar);
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0595b {
        TextView gCK;
        TbImageView gCL;
        TextView gCM;
        RelativeLayout gCN;
        TextView gCO;
        TextView gCP;
        TbImageView gCQ;
        TextView gCR;
        RelativeLayout gCS;
        TextView gCT;
        TextView gCU;
        TbImageView gCV;
        TextView gCW;
        RelativeLayout gCX;
        TextView gCY;
        View gCZ;
        TextView title;

        private C0595b() {
        }
    }
}
