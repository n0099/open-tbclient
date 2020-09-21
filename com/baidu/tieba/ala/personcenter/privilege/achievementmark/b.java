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
    private TbPageContext<?> ehG;
    private a gYs;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.ehG = null;
        this.ehG = tbPageContext;
        this.gYs = aVar;
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
        C0651b c0651b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0651b c0651b2 = new C0651b();
            c0651b2.gYv = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0651b2.gYw = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0651b2.gYx = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0651b2.gYy = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0651b2.gYz = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0651b2.gYA = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0651b2.gYB = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0651b2.gYC = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0651b2.gYD = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0651b2.gYE = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0651b2.gYF = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0651b2.gYG = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0651b2.gYH = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0651b2.gYI = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0651b2.gYJ = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0651b2.gYK = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0651b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0651b = c0651b2;
        } else {
            c0651b = (C0651b) view.getTag();
        }
        a(c0651b);
        if (aVar != null) {
            if (aVar.vk(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vk = aVar.vk(0);
                c0651b.gYy.setVisibility(0);
                c0651b.gYv.setText(vk.caL() == null ? "" : vk.caL());
                if (vk.caM() != null) {
                    c0651b.gYw.setDefaultBgResource(R.color.transparent);
                    c0651b.gYw.startLoad(vk.caM(), 10, false);
                }
                c(c0651b.gYx, vk.caN());
                c(c0651b.gYw, vk.caN());
                a(c0651b.gYz, vk.caR(), vk.price);
                c0651b.gYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gYs != null) {
                            b.this.gYs.a(aVar.vk(0));
                        }
                    }
                });
            } else {
                c0651b.gYy.setVisibility(4);
                c0651b.gYy.setOnClickListener(null);
            }
            if (aVar.vk(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vk2 = aVar.vk(1);
                c0651b.gYD.setVisibility(0);
                c0651b.gYA.setText(vk2.caL() == null ? "" : vk2.caL());
                if (vk2.caM() != null) {
                    c0651b.gYB.setDefaultBgResource(R.color.transparent);
                    c0651b.gYB.startLoad(vk2.caM(), 10, false);
                }
                c(c0651b.gYC, vk2.caN());
                c(c0651b.gYB, vk2.caN());
                a(c0651b.gYE, vk2.caR(), vk2.price);
                c0651b.gYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gYs != null) {
                            b.this.gYs.a(aVar.vk(1));
                        }
                    }
                });
            } else {
                c0651b.gYD.setVisibility(4);
                c0651b.gYD.setOnClickListener(null);
            }
            if (aVar.vk(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b vk3 = aVar.vk(2);
                c0651b.gYI.setVisibility(0);
                c0651b.gYF.setText(vk3.caL() == null ? "" : vk3.caL());
                if (vk3.caM() != null) {
                    c0651b.gYG.setDefaultBgResource(R.color.transparent);
                    c0651b.gYG.startLoad(vk3.caM(), 10, false);
                }
                c(c0651b.gYH, vk3.caN());
                c(c0651b.gYG, vk3.caN());
                a(c0651b.gYJ, vk3.caR(), vk3.price);
                c0651b.gYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gYs != null) {
                            b.this.gYs.a(aVar.vk(2));
                        }
                    }
                });
            } else {
                c0651b.gYI.setVisibility(4);
                c0651b.gYI.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0651b.gYK.setVisibility(0);
            } else {
                c0651b.gYK.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.caH() != null) {
                c0651b.title.setVisibility(0);
                c0651b.title.setText(aVar.caH());
            } else {
                c0651b.title.setVisibility(8);
            }
        }
        view.setTag(c0651b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.ehG.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0651b c0651b) {
        if (c0651b != null) {
            ap.setViewTextColor(c0651b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYv, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYA, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYF, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYz, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYE, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0651b.gYJ, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0651b.gYw.setDefaultResource(R.drawable.pic_live_honor_1);
                c0651b.gYw.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0651b.gYB.setDefaultResource(R.drawable.pic_live_honor_1);
                c0651b.gYB.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0651b.gYG.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0651b.gYw.setDefaultResource(R.drawable.pic_live_honor);
                c0651b.gYw.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0651b.gYB.setDefaultResource(R.drawable.pic_live_honor);
                c0651b.gYB.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0651b.gYG.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0651b.gYK, R.color.cp_bg_line_c);
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
            this.list = ck(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> ck(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Hd(list.get(i3).caH());
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
                        aVar.Hd(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].caH());
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
    public class C0651b {
        TextView gYA;
        TbImageView gYB;
        TextView gYC;
        RelativeLayout gYD;
        TextView gYE;
        TextView gYF;
        TbImageView gYG;
        TextView gYH;
        RelativeLayout gYI;
        TextView gYJ;
        View gYK;
        TextView gYv;
        TbImageView gYw;
        TextView gYx;
        RelativeLayout gYy;
        TextView gYz;
        TextView title;

        private C0651b() {
        }
    }
}
