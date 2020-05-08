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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> duK;
    private a gaN;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.duK = null;
        this.duK = tbPageContext;
        this.gaN = aVar;
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
        C0536b c0536b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0536b c0536b2 = new C0536b();
            c0536b2.gaQ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0536b2.gaR = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0536b2.gaS = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0536b2.gaT = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0536b2.gaU = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0536b2.gaV = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0536b2.gaW = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0536b2.gaX = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0536b2.gaY = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0536b2.gaZ = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0536b2.gba = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0536b2.gbb = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0536b2.gbc = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0536b2.gbd = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0536b2.gbe = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0536b2.gbf = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0536b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0536b = c0536b2;
        } else {
            c0536b = (C0536b) view.getTag();
        }
        a(c0536b);
        if (aVar != null) {
            if (aVar.ri(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ri = aVar.ri(0);
                c0536b.gaT.setVisibility(0);
                c0536b.gaQ.setText(ri.bCe() == null ? "" : ri.bCe());
                if (ri.bCf() != null) {
                    c0536b.gaR.setDefaultBgResource(R.color.transparent);
                    c0536b.gaR.startLoad(ri.bCf(), 10, false);
                }
                b(c0536b.gaS, ri.bCg());
                c(c0536b.gaR, ri.bCg());
                a(c0536b.gaU, ri.bCk(), ri.price);
                c0536b.gaT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gaN != null) {
                            b.this.gaN.a(aVar.ri(0));
                        }
                    }
                });
            } else {
                c0536b.gaT.setVisibility(4);
                c0536b.gaT.setOnClickListener(null);
            }
            if (aVar.ri(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ri2 = aVar.ri(1);
                c0536b.gaY.setVisibility(0);
                c0536b.gaV.setText(ri2.bCe() == null ? "" : ri2.bCe());
                if (ri2.bCf() != null) {
                    c0536b.gaW.setDefaultBgResource(R.color.transparent);
                    c0536b.gaW.startLoad(ri2.bCf(), 10, false);
                }
                b(c0536b.gaX, ri2.bCg());
                c(c0536b.gaW, ri2.bCg());
                a(c0536b.gaZ, ri2.bCk(), ri2.price);
                c0536b.gaY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gaN != null) {
                            b.this.gaN.a(aVar.ri(1));
                        }
                    }
                });
            } else {
                c0536b.gaY.setVisibility(4);
                c0536b.gaY.setOnClickListener(null);
            }
            if (aVar.ri(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ri3 = aVar.ri(2);
                c0536b.gbd.setVisibility(0);
                c0536b.gba.setText(ri3.bCe() == null ? "" : ri3.bCe());
                if (ri3.bCf() != null) {
                    c0536b.gbb.setDefaultBgResource(R.color.transparent);
                    c0536b.gbb.startLoad(ri3.bCf(), 10, false);
                }
                b(c0536b.gbc, ri3.bCg());
                c(c0536b.gbb, ri3.bCg());
                a(c0536b.gbe, ri3.bCk(), ri3.price);
                c0536b.gbd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gaN != null) {
                            b.this.gaN.a(aVar.ri(2));
                        }
                    }
                });
            } else {
                c0536b.gbd.setVisibility(4);
                c0536b.gbd.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0536b.gbf.setVisibility(0);
            } else {
                c0536b.gbf.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bCa() != null) {
                c0536b.title.setVisibility(0);
                c0536b.title.setText(aVar.bCa());
            } else {
                c0536b.title.setVisibility(8);
            }
        }
        view.setTag(c0536b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.duK.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.duK.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.duK.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0536b c0536b) {
        if (c0536b != null) {
            am.setViewTextColor(c0536b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gaQ, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gaV, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gba, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gaU, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gaZ, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0536b.gbe, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0536b.gaR.setDefaultResource(R.drawable.pic_live_honor_1);
                c0536b.gaR.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0536b.gaW.setDefaultResource(R.drawable.pic_live_honor_1);
                c0536b.gaW.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0536b.gbb.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0536b.gaR.setDefaultResource(R.drawable.pic_live_honor);
                c0536b.gaR.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0536b.gaW.setDefaultResource(R.drawable.pic_live_honor);
                c0536b.gaW.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0536b.gbb.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0536b.gbf, R.color.cp_bg_line_c);
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
            this.list = bQ(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> bQ(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Bp(list.get(i3).bCa());
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
                        aVar.Bp(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bCa());
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
    public class C0536b {
        TextView gaQ;
        TbImageView gaR;
        TextView gaS;
        RelativeLayout gaT;
        TextView gaU;
        TextView gaV;
        TbImageView gaW;
        TextView gaX;
        RelativeLayout gaY;
        TextView gaZ;
        TextView gba;
        TbImageView gbb;
        TextView gbc;
        RelativeLayout gbd;
        TextView gbe;
        View gbf;
        TextView title;

        private C0536b() {
        }
    }
}
