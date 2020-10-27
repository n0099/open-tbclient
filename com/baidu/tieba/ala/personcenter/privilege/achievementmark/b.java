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
    private TbPageContext<?> eCn;
    private a hzo;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eCn = null;
        this.eCn = tbPageContext;
        this.hzo = aVar;
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
        C0685b c0685b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0685b c0685b2 = new C0685b();
            c0685b2.hzr = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0685b2.hzs = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0685b2.hzt = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0685b2.hzu = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0685b2.hzv = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0685b2.hzw = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0685b2.hzx = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0685b2.hzy = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0685b2.hzz = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0685b2.hzA = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0685b2.hzB = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0685b2.hzC = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0685b2.hzD = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0685b2.hzE = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0685b2.hzF = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0685b2.hzG = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0685b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0685b = c0685b2;
        } else {
            c0685b = (C0685b) view.getTag();
        }
        a(c0685b);
        if (aVar != null) {
            if (aVar.wk(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wk = aVar.wk(0);
                c0685b.hzu.setVisibility(0);
                c0685b.hzr.setText(wk.chl() == null ? "" : wk.chl());
                if (wk.chm() != null) {
                    c0685b.hzs.setDefaultBgResource(R.color.transparent);
                    c0685b.hzs.startLoad(wk.chm(), 10, false);
                }
                c(c0685b.hzt, wk.chn());
                c(c0685b.hzs, wk.chn());
                a(c0685b.hzv, wk.chr(), wk.price);
                c0685b.hzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hzo != null) {
                            b.this.hzo.a(aVar.wk(0));
                        }
                    }
                });
            } else {
                c0685b.hzu.setVisibility(4);
                c0685b.hzu.setOnClickListener(null);
            }
            if (aVar.wk(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wk2 = aVar.wk(1);
                c0685b.hzz.setVisibility(0);
                c0685b.hzw.setText(wk2.chl() == null ? "" : wk2.chl());
                if (wk2.chm() != null) {
                    c0685b.hzx.setDefaultBgResource(R.color.transparent);
                    c0685b.hzx.startLoad(wk2.chm(), 10, false);
                }
                c(c0685b.hzy, wk2.chn());
                c(c0685b.hzx, wk2.chn());
                a(c0685b.hzA, wk2.chr(), wk2.price);
                c0685b.hzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hzo != null) {
                            b.this.hzo.a(aVar.wk(1));
                        }
                    }
                });
            } else {
                c0685b.hzz.setVisibility(4);
                c0685b.hzz.setOnClickListener(null);
            }
            if (aVar.wk(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wk3 = aVar.wk(2);
                c0685b.hzE.setVisibility(0);
                c0685b.hzB.setText(wk3.chl() == null ? "" : wk3.chl());
                if (wk3.chm() != null) {
                    c0685b.hzC.setDefaultBgResource(R.color.transparent);
                    c0685b.hzC.startLoad(wk3.chm(), 10, false);
                }
                c(c0685b.hzD, wk3.chn());
                c(c0685b.hzC, wk3.chn());
                a(c0685b.hzF, wk3.chr(), wk3.price);
                c0685b.hzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hzo != null) {
                            b.this.hzo.a(aVar.wk(2));
                        }
                    }
                });
            } else {
                c0685b.hzE.setVisibility(4);
                c0685b.hzE.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0685b.hzG.setVisibility(0);
            } else {
                c0685b.hzG.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.chh() != null) {
                c0685b.title.setVisibility(0);
                c0685b.title.setText(aVar.chh());
            } else {
                c0685b.title.setVisibility(8);
            }
        }
        view.setTag(c0685b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eCn.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eCn.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0685b c0685b) {
        if (c0685b != null) {
            ap.setViewTextColor(c0685b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzr, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzw, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzB, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzv, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzA, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0685b.hzF, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0685b.hzs.setDefaultResource(R.drawable.pic_live_honor_1);
                c0685b.hzs.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0685b.hzx.setDefaultResource(R.drawable.pic_live_honor_1);
                c0685b.hzx.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0685b.hzC.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0685b.hzs.setDefaultResource(R.drawable.pic_live_honor);
                c0685b.hzs.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0685b.hzx.setDefaultResource(R.drawable.pic_live_honor);
                c0685b.hzx.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0685b.hzC.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0685b.hzG, R.color.cp_bg_line_c);
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
            this.list = cw(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cw(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Iq(list.get(i3).chh());
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
                        aVar.Iq(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].chh());
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
    public class C0685b {
        TextView hzA;
        TextView hzB;
        TbImageView hzC;
        TextView hzD;
        RelativeLayout hzE;
        TextView hzF;
        View hzG;
        TextView hzr;
        TbImageView hzs;
        TextView hzt;
        RelativeLayout hzu;
        TextView hzv;
        TextView hzw;
        TbImageView hzx;
        TextView hzy;
        RelativeLayout hzz;
        TextView title;

        private C0685b() {
        }
    }
}
