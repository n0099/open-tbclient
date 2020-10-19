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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> etO;
    private a hnt;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.etO = null;
        this.etO = tbPageContext;
        this.hnt = aVar;
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
        C0669b c0669b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0669b c0669b2 = new C0669b();
            c0669b2.hnw = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0669b2.hnx = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0669b2.hny = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0669b2.hnz = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0669b2.hnA = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0669b2.hnB = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0669b2.hnC = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0669b2.hnD = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0669b2.hnE = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0669b2.hnF = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0669b2.hnG = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0669b2.hnH = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0669b2.hnI = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0669b2.hnJ = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0669b2.hnK = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0669b2.hnL = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0669b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0669b = c0669b2;
        } else {
            c0669b = (C0669b) view.getTag();
        }
        a(c0669b);
        if (aVar != null) {
            if (aVar.vQ(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vQ = aVar.vQ(0);
                c0669b.hnz.setVisibility(0);
                c0669b.hnw.setText(vQ.cej() == null ? "" : vQ.cej());
                if (vQ.cek() != null) {
                    c0669b.hnx.setDefaultBgResource(R.color.transparent);
                    c0669b.hnx.startLoad(vQ.cek(), 10, false);
                }
                c(c0669b.hny, vQ.cel());
                c(c0669b.hnx, vQ.cel());
                a(c0669b.hnA, vQ.cep(), vQ.price);
                c0669b.hnz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hnt != null) {
                            b.this.hnt.a(aVar.vQ(0));
                        }
                    }
                });
            } else {
                c0669b.hnz.setVisibility(4);
                c0669b.hnz.setOnClickListener(null);
            }
            if (aVar.vQ(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vQ2 = aVar.vQ(1);
                c0669b.hnE.setVisibility(0);
                c0669b.hnB.setText(vQ2.cej() == null ? "" : vQ2.cej());
                if (vQ2.cek() != null) {
                    c0669b.hnC.setDefaultBgResource(R.color.transparent);
                    c0669b.hnC.startLoad(vQ2.cek(), 10, false);
                }
                c(c0669b.hnD, vQ2.cel());
                c(c0669b.hnC, vQ2.cel());
                a(c0669b.hnF, vQ2.cep(), vQ2.price);
                c0669b.hnE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hnt != null) {
                            b.this.hnt.a(aVar.vQ(1));
                        }
                    }
                });
            } else {
                c0669b.hnE.setVisibility(4);
                c0669b.hnE.setOnClickListener(null);
            }
            if (aVar.vQ(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vQ3 = aVar.vQ(2);
                c0669b.hnJ.setVisibility(0);
                c0669b.hnG.setText(vQ3.cej() == null ? "" : vQ3.cej());
                if (vQ3.cek() != null) {
                    c0669b.hnH.setDefaultBgResource(R.color.transparent);
                    c0669b.hnH.startLoad(vQ3.cek(), 10, false);
                }
                c(c0669b.hnI, vQ3.cel());
                c(c0669b.hnH, vQ3.cel());
                a(c0669b.hnK, vQ3.cep(), vQ3.price);
                c0669b.hnJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hnt != null) {
                            b.this.hnt.a(aVar.vQ(2));
                        }
                    }
                });
            } else {
                c0669b.hnJ.setVisibility(4);
                c0669b.hnJ.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0669b.hnL.setVisibility(0);
            } else {
                c0669b.hnL.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cef() != null) {
                c0669b.title.setVisibility(0);
                c0669b.title.setText(aVar.cef());
            } else {
                c0669b.title.setVisibility(8);
            }
        }
        view.setTag(c0669b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.etO.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.etO.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.etO.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0669b c0669b) {
        if (c0669b != null) {
            ap.setViewTextColor(c0669b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnw, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnB, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnG, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnA, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnF, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0669b.hnK, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0669b.hnx.setDefaultResource(R.drawable.pic_live_honor_1);
                c0669b.hnx.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0669b.hnC.setDefaultResource(R.drawable.pic_live_honor_1);
                c0669b.hnC.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0669b.hnH.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0669b.hnx.setDefaultResource(R.drawable.pic_live_honor);
                c0669b.hnx.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0669b.hnC.setDefaultResource(R.drawable.pic_live_honor);
                c0669b.hnC.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0669b.hnH.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0669b.hnL, R.color.cp_bg_line_c);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ap.setViewTextColor(textView, R.color.cp_cont_d);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ap.setViewTextColor(textView, R.color.live_cp_other_b);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ap.setViewTextColor(textView, R.color.cp_link_tip_a);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ap.setViewTextColor(textView, R.color.cp_cont_d);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
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
            this.list = cn(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cn(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].HR(list.get(i3).cef());
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
                        aVar.HR(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cef());
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
    /* loaded from: classes4.dex */
    public class C0669b {
        TextView hnA;
        TextView hnB;
        TbImageView hnC;
        TextView hnD;
        RelativeLayout hnE;
        TextView hnF;
        TextView hnG;
        TbImageView hnH;
        TextView hnI;
        RelativeLayout hnJ;
        TextView hnK;
        View hnL;
        TextView hnw;
        TbImageView hnx;
        TextView hny;
        RelativeLayout hnz;
        TextView title;

        private C0669b() {
        }
    }
}
