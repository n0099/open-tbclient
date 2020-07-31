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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> dVN;
    private a gIe;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.dVN = null;
        this.dVN = tbPageContext;
        this.gIe = aVar;
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
        C0604b c0604b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0604b c0604b2 = new C0604b();
            c0604b2.gIh = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0604b2.gIi = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0604b2.gIj = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0604b2.gIk = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0604b2.gIl = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0604b2.gIm = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0604b2.gIn = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0604b2.gIo = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0604b2.gIp = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0604b2.gIq = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0604b2.gIr = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0604b2.gIs = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0604b2.gIt = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0604b2.gIu = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0604b2.gIv = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0604b2.gIw = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0604b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0604b = c0604b2;
        } else {
            c0604b = (C0604b) view.getTag();
        }
        a(c0604b);
        if (aVar != null) {
            if (aVar.sD(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sD = aVar.sD(0);
                c0604b.gIk.setVisibility(0);
                c0604b.gIh.setText(sD.bOO() == null ? "" : sD.bOO());
                if (sD.bOP() != null) {
                    c0604b.gIi.setDefaultBgResource(R.color.transparent);
                    c0604b.gIi.startLoad(sD.bOP(), 10, false);
                }
                c(c0604b.gIj, sD.bOQ());
                c(c0604b.gIi, sD.bOQ());
                a(c0604b.gIl, sD.bOU(), sD.price);
                c0604b.gIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gIe != null) {
                            b.this.gIe.a(aVar.sD(0));
                        }
                    }
                });
            } else {
                c0604b.gIk.setVisibility(4);
                c0604b.gIk.setOnClickListener(null);
            }
            if (aVar.sD(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sD2 = aVar.sD(1);
                c0604b.gIp.setVisibility(0);
                c0604b.gIm.setText(sD2.bOO() == null ? "" : sD2.bOO());
                if (sD2.bOP() != null) {
                    c0604b.gIn.setDefaultBgResource(R.color.transparent);
                    c0604b.gIn.startLoad(sD2.bOP(), 10, false);
                }
                c(c0604b.gIo, sD2.bOQ());
                c(c0604b.gIn, sD2.bOQ());
                a(c0604b.gIq, sD2.bOU(), sD2.price);
                c0604b.gIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gIe != null) {
                            b.this.gIe.a(aVar.sD(1));
                        }
                    }
                });
            } else {
                c0604b.gIp.setVisibility(4);
                c0604b.gIp.setOnClickListener(null);
            }
            if (aVar.sD(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b sD3 = aVar.sD(2);
                c0604b.gIu.setVisibility(0);
                c0604b.gIr.setText(sD3.bOO() == null ? "" : sD3.bOO());
                if (sD3.bOP() != null) {
                    c0604b.gIs.setDefaultBgResource(R.color.transparent);
                    c0604b.gIs.startLoad(sD3.bOP(), 10, false);
                }
                c(c0604b.gIt, sD3.bOQ());
                c(c0604b.gIs, sD3.bOQ());
                a(c0604b.gIv, sD3.bOU(), sD3.price);
                c0604b.gIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.gIe != null) {
                            b.this.gIe.a(aVar.sD(2));
                        }
                    }
                });
            } else {
                c0604b.gIu.setVisibility(4);
                c0604b.gIu.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0604b.gIw.setVisibility(0);
            } else {
                c0604b.gIw.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.bOK() != null) {
                c0604b.title.setVisibility(0);
                c0604b.title.setText(aVar.bOK());
            } else {
                c0604b.title.setVisibility(8);
            }
        }
        view.setTag(c0604b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.dVN.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0604b c0604b) {
        if (c0604b != null) {
            ao.setViewTextColor(c0604b.title, R.color.cp_cont_b, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIh, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIm, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIr, R.color.cp_cont_j, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIl, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIq, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0604b.gIv, R.color.cp_link_tip_d, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0604b.gIi.setDefaultResource(R.drawable.pic_live_honor_1);
                c0604b.gIi.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0604b.gIn.setDefaultResource(R.drawable.pic_live_honor_1);
                c0604b.gIn.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0604b.gIs.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0604b.gIi.setDefaultResource(R.drawable.pic_live_honor);
                c0604b.gIi.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0604b.gIn.setDefaultResource(R.drawable.pic_live_honor);
                c0604b.gIn.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0604b.gIs.setDefaultResource(R.drawable.pic_live_honor);
            }
            ao.setBackgroundColor(c0604b.gIw, R.color.cp_bg_line_c);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ao.setViewTextColor(textView, R.color.cp_cont_d);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ao.setViewTextColor(textView, R.color.live_cp_other_b);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ao.setViewTextColor(textView, R.color.cp_link_tip_a);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ao.setViewTextColor(textView, R.color.cp_cont_d);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
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
            this.list = cd(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cd(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Ek(list.get(i3).bOK());
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
                        aVar.Ek(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].bOK());
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
    public class C0604b {
        TextView gIh;
        TbImageView gIi;
        TextView gIj;
        RelativeLayout gIk;
        TextView gIl;
        TextView gIm;
        TbImageView gIn;
        TextView gIo;
        RelativeLayout gIp;
        TextView gIq;
        TextView gIr;
        TbImageView gIs;
        TextView gIt;
        RelativeLayout gIu;
        TextView gIv;
        View gIw;
        TextView title;

        private C0604b() {
        }
    }
}
