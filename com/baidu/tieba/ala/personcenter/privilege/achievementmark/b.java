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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> cRe;
    private a fsM;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.cRe = null;
        this.cRe = tbPageContext;
        this.fsM = aVar;
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
        C0471b c0471b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0471b c0471b2 = new C0471b();
            c0471b2.fsP = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0471b2.fsQ = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0471b2.fsR = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0471b2.fsS = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0471b2.fsT = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0471b2.fsU = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0471b2.fsV = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0471b2.fsW = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0471b2.fsX = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0471b2.fsY = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0471b2.fsZ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0471b2.fta = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0471b2.ftb = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0471b2.ftc = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0471b2.ftd = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0471b2.fte = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0471b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0471b = c0471b2;
        } else {
            c0471b = (C0471b) view.getTag();
        }
        a(c0471b);
        if (aVar != null) {
            if (aVar.qG(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qG = aVar.qG(0);
                c0471b.fsS.setVisibility(0);
                c0471b.fsP.setText(qG.bqL() == null ? "" : qG.bqL());
                if (qG.bqM() != null) {
                    c0471b.fsQ.setDefaultBgResource(R.color.transparent);
                    c0471b.fsQ.startLoad(qG.bqM(), 10, false);
                }
                b(c0471b.fsR, qG.bqN());
                c(c0471b.fsQ, qG.bqN());
                a(c0471b.fsT, qG.bqR(), qG.price);
                c0471b.fsS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fsM != null) {
                            b.this.fsM.a(aVar.qG(0));
                        }
                    }
                });
            } else {
                c0471b.fsS.setVisibility(4);
                c0471b.fsS.setOnClickListener(null);
            }
            if (aVar.qG(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qG2 = aVar.qG(1);
                c0471b.fsX.setVisibility(0);
                c0471b.fsU.setText(qG2.bqL() == null ? "" : qG2.bqL());
                if (qG2.bqM() != null) {
                    c0471b.fsV.setDefaultBgResource(R.color.transparent);
                    c0471b.fsV.startLoad(qG2.bqM(), 10, false);
                }
                b(c0471b.fsW, qG2.bqN());
                c(c0471b.fsV, qG2.bqN());
                a(c0471b.fsY, qG2.bqR(), qG2.price);
                c0471b.fsX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fsM != null) {
                            b.this.fsM.a(aVar.qG(1));
                        }
                    }
                });
            } else {
                c0471b.fsX.setVisibility(4);
                c0471b.fsX.setOnClickListener(null);
            }
            if (aVar.qG(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qG3 = aVar.qG(2);
                c0471b.ftc.setVisibility(0);
                c0471b.fsZ.setText(qG3.bqL() == null ? "" : qG3.bqL());
                if (qG3.bqM() != null) {
                    c0471b.fta.setDefaultBgResource(R.color.transparent);
                    c0471b.fta.startLoad(qG3.bqM(), 10, false);
                }
                b(c0471b.ftb, qG3.bqN());
                c(c0471b.fta, qG3.bqN());
                a(c0471b.ftd, qG3.bqR(), qG3.price);
                c0471b.ftc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fsM != null) {
                            b.this.fsM.a(aVar.qG(2));
                        }
                    }
                });
            } else {
                c0471b.ftc.setVisibility(4);
                c0471b.ftc.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0471b.fte.setVisibility(0);
            } else {
                c0471b.fte.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bqH() != null) {
                c0471b.title.setVisibility(0);
                c0471b.title.setText(aVar.bqH());
            } else {
                c0471b.title.setVisibility(8);
            }
        }
        view.setTag(c0471b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.cRe.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0471b c0471b) {
        if (c0471b != null) {
            am.setViewTextColor(c0471b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.fsP, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.fsU, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.fsZ, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.fsT, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.fsY, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0471b.ftd, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0471b.fsQ.setDefaultResource(R.drawable.pic_live_honor_1);
                c0471b.fsQ.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0471b.fsV.setDefaultResource(R.drawable.pic_live_honor_1);
                c0471b.fsV.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0471b.fta.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0471b.fsQ.setDefaultResource(R.drawable.pic_live_honor);
                c0471b.fsQ.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0471b.fsV.setDefaultResource(R.drawable.pic_live_honor);
                c0471b.fsV.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0471b.fta.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0471b.fte, R.color.cp_bg_line_c);
        }
    }

    private void b(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                am.setViewTextColor(textView, (int) R.color.cp_cont_d);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                am.setViewTextColor(textView, (int) R.color.live_cp_other_b);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                am.setViewTextColor(textView, (int) R.color.cp_cont_d);
                am.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
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
            this.list = bH(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bH(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].zn(list.get(i3).bqH());
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
                        aVar.zn(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bqH());
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
    /* loaded from: classes2.dex */
    public class C0471b {
        TextView fsP;
        TbImageView fsQ;
        TextView fsR;
        RelativeLayout fsS;
        TextView fsT;
        TextView fsU;
        TbImageView fsV;
        TextView fsW;
        RelativeLayout fsX;
        TextView fsY;
        TextView fsZ;
        TbImageView fta;
        TextView ftb;
        RelativeLayout ftc;
        TextView ftd;
        View fte;
        TextView title;

        private C0471b() {
        }
    }
}
