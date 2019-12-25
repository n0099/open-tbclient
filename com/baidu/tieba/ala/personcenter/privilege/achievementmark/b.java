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
    private TbPageContext<?> cQU;
    private a fpD;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.cQU = null;
        this.cQU = tbPageContext;
        this.fpD = aVar;
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
        C0467b c0467b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0467b c0467b2 = new C0467b();
            c0467b2.fpG = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0467b2.fpH = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0467b2.fpI = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0467b2.fpJ = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0467b2.fpK = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0467b2.fpL = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0467b2.fpM = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0467b2.fpN = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0467b2.fpO = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0467b2.fpP = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0467b2.fpQ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0467b2.fpR = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0467b2.fpS = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0467b2.fpT = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0467b2.fpU = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0467b2.fpV = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0467b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0467b = c0467b2;
        } else {
            c0467b = (C0467b) view.getTag();
        }
        a(c0467b);
        if (aVar != null) {
            if (aVar.qB(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qB = aVar.qB(0);
                c0467b.fpJ.setVisibility(0);
                c0467b.fpG.setText(qB.bpK() == null ? "" : qB.bpK());
                if (qB.bpL() != null) {
                    c0467b.fpH.setDefaultBgResource(R.color.transparent);
                    c0467b.fpH.startLoad(qB.bpL(), 10, false);
                }
                b(c0467b.fpI, qB.bpM());
                b(c0467b.fpH, qB.bpM());
                a(c0467b.fpK, qB.bpQ(), qB.price);
                c0467b.fpJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fpD != null) {
                            b.this.fpD.a(aVar.qB(0));
                        }
                    }
                });
            } else {
                c0467b.fpJ.setVisibility(4);
                c0467b.fpJ.setOnClickListener(null);
            }
            if (aVar.qB(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qB2 = aVar.qB(1);
                c0467b.fpO.setVisibility(0);
                c0467b.fpL.setText(qB2.bpK() == null ? "" : qB2.bpK());
                if (qB2.bpL() != null) {
                    c0467b.fpM.setDefaultBgResource(R.color.transparent);
                    c0467b.fpM.startLoad(qB2.bpL(), 10, false);
                }
                b(c0467b.fpN, qB2.bpM());
                b(c0467b.fpM, qB2.bpM());
                a(c0467b.fpP, qB2.bpQ(), qB2.price);
                c0467b.fpO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fpD != null) {
                            b.this.fpD.a(aVar.qB(1));
                        }
                    }
                });
            } else {
                c0467b.fpO.setVisibility(4);
                c0467b.fpO.setOnClickListener(null);
            }
            if (aVar.qB(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b qB3 = aVar.qB(2);
                c0467b.fpT.setVisibility(0);
                c0467b.fpQ.setText(qB3.bpK() == null ? "" : qB3.bpK());
                if (qB3.bpL() != null) {
                    c0467b.fpR.setDefaultBgResource(R.color.transparent);
                    c0467b.fpR.startLoad(qB3.bpL(), 10, false);
                }
                b(c0467b.fpS, qB3.bpM());
                b(c0467b.fpR, qB3.bpM());
                a(c0467b.fpU, qB3.bpQ(), qB3.price);
                c0467b.fpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.fpD != null) {
                            b.this.fpD.a(aVar.qB(2));
                        }
                    }
                });
            } else {
                c0467b.fpT.setVisibility(4);
                c0467b.fpT.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0467b.fpV.setVisibility(0);
            } else {
                c0467b.fpV.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bpG() != null) {
                c0467b.title.setVisibility(0);
                c0467b.title.setText(aVar.bpG());
            } else {
                c0467b.title.setVisibility(8);
            }
        }
        view.setTag(c0467b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.cQU.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds4));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setText(AlaStringHelper.formatLowercasekDou(j));
            return;
        }
        textView.setVisibility(8);
    }

    private void b(TbImageView tbImageView, int i) {
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

    private void a(C0467b c0467b) {
        if (c0467b != null) {
            am.setViewTextColor(c0467b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpG, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpL, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpQ, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpK, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpP, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            am.setViewTextColor(c0467b.fpU, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0467b.fpH.setDefaultResource(R.drawable.pic_live_honor_1);
                c0467b.fpH.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0467b.fpM.setDefaultResource(R.drawable.pic_live_honor_1);
                c0467b.fpM.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0467b.fpR.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0467b.fpH.setDefaultResource(R.drawable.pic_live_honor);
                c0467b.fpH.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0467b.fpM.setDefaultResource(R.drawable.pic_live_honor);
                c0467b.fpM.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0467b.fpR.setDefaultResource(R.drawable.pic_live_honor);
            }
            am.setBackgroundColor(c0467b.fpV, R.color.cp_bg_line_c);
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
                bVarArr[i4 / 3][i4 % 3].ze(list.get(i3).bpG());
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
                        aVar.ze(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bpG());
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
    public class C0467b {
        TextView fpG;
        TbImageView fpH;
        TextView fpI;
        RelativeLayout fpJ;
        TextView fpK;
        TextView fpL;
        TbImageView fpM;
        TextView fpN;
        RelativeLayout fpO;
        TextView fpP;
        TextView fpQ;
        TbImageView fpR;
        TextView fpS;
        RelativeLayout fpT;
        TextView fpU;
        View fpV;
        TextView title;

        private C0467b() {
        }
    }
}
