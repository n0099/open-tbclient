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
    private TbPageContext<?> efn;
    private a gUH;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.efn = null;
        this.efn = tbPageContext;
        this.gUH = aVar;
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
        C0654b c0654b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0654b c0654b2 = new C0654b();
            c0654b2.gUK = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0654b2.gUL = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0654b2.gUM = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0654b2.gUN = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0654b2.gUO = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0654b2.gUP = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0654b2.gUQ = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0654b2.gUR = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0654b2.gUS = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0654b2.gUT = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0654b2.gUU = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0654b2.gUV = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0654b2.gUW = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0654b2.gUX = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0654b2.gUY = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0654b2.gUZ = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0654b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0654b = c0654b2;
        } else {
            c0654b = (C0654b) view.getTag();
        }
        a(c0654b);
        if (aVar != null) {
            if (aVar.uR(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b uR = aVar.uR(0);
                c0654b.gUN.setVisibility(0);
                c0654b.gUK.setText(uR.bYO() == null ? "" : uR.bYO());
                if (uR.bYP() != null) {
                    c0654b.gUL.setDefaultBgResource(R.color.transparent);
                    c0654b.gUL.startLoad(uR.bYP(), 10, false);
                }
                c(c0654b.gUM, uR.bYQ());
                c(c0654b.gUL, uR.bYQ());
                a(c0654b.gUO, uR.bYU(), uR.price);
                c0654b.gUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gUH != null) {
                            b.this.gUH.a(aVar.uR(0));
                        }
                    }
                });
            } else {
                c0654b.gUN.setVisibility(4);
                c0654b.gUN.setOnClickListener(null);
            }
            if (aVar.uR(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b uR2 = aVar.uR(1);
                c0654b.gUS.setVisibility(0);
                c0654b.gUP.setText(uR2.bYO() == null ? "" : uR2.bYO());
                if (uR2.bYP() != null) {
                    c0654b.gUQ.setDefaultBgResource(R.color.transparent);
                    c0654b.gUQ.startLoad(uR2.bYP(), 10, false);
                }
                c(c0654b.gUR, uR2.bYQ());
                c(c0654b.gUQ, uR2.bYQ());
                a(c0654b.gUT, uR2.bYU(), uR2.price);
                c0654b.gUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gUH != null) {
                            b.this.gUH.a(aVar.uR(1));
                        }
                    }
                });
            } else {
                c0654b.gUS.setVisibility(4);
                c0654b.gUS.setOnClickListener(null);
            }
            if (aVar.uR(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b uR3 = aVar.uR(2);
                c0654b.gUX.setVisibility(0);
                c0654b.gUU.setText(uR3.bYO() == null ? "" : uR3.bYO());
                if (uR3.bYP() != null) {
                    c0654b.gUV.setDefaultBgResource(R.color.transparent);
                    c0654b.gUV.startLoad(uR3.bYP(), 10, false);
                }
                c(c0654b.gUW, uR3.bYQ());
                c(c0654b.gUV, uR3.bYQ());
                a(c0654b.gUY, uR3.bYU(), uR3.price);
                c0654b.gUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gUH != null) {
                            b.this.gUH.a(aVar.uR(2));
                        }
                    }
                });
            } else {
                c0654b.gUX.setVisibility(4);
                c0654b.gUX.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0654b.gUZ.setVisibility(0);
            } else {
                c0654b.gUZ.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bYK() != null) {
                c0654b.title.setVisibility(0);
                c0654b.title.setText(aVar.bYK());
            } else {
                c0654b.title.setVisibility(8);
            }
        }
        view.setTag(c0654b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.efn.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.efn.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.efn.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0654b c0654b) {
        if (c0654b != null) {
            ap.setViewTextColor(c0654b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUK, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUP, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUU, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUO, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUT, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0654b.gUY, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0654b.gUL.setDefaultResource(R.drawable.pic_live_honor_1);
                c0654b.gUL.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0654b.gUQ.setDefaultResource(R.drawable.pic_live_honor_1);
                c0654b.gUQ.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0654b.gUV.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0654b.gUL.setDefaultResource(R.drawable.pic_live_honor);
                c0654b.gUL.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0654b.gUQ.setDefaultResource(R.drawable.pic_live_honor);
                c0654b.gUQ.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0654b.gUV.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0654b.gUZ, R.color.cp_bg_line_c);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ap.setViewTextColor(textView, (int) R.color.cp_cont_d);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ap.setViewTextColor(textView, (int) R.color.live_cp_other_b);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ap.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ap.setViewTextColor(textView, (int) R.color.cp_cont_d);
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
            this.list = cf(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cf(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].GJ(list.get(i3).bYK());
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
                        aVar.GJ(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bYK());
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
    public class C0654b {
        TextView gUK;
        TbImageView gUL;
        TextView gUM;
        RelativeLayout gUN;
        TextView gUO;
        TextView gUP;
        TbImageView gUQ;
        TextView gUR;
        RelativeLayout gUS;
        TextView gUT;
        TextView gUU;
        TbImageView gUV;
        TextView gUW;
        RelativeLayout gUX;
        TextView gUY;
        View gUZ;
        TextView title;

        private C0654b() {
        }
    }
}
