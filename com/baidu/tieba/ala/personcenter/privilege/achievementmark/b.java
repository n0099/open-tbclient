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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eXu;
    private a iaW;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eXu = null;
        this.eXu = tbPageContext;
        this.iaW = aVar;
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
        C0704b c0704b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0704b c0704b2 = new C0704b();
            c0704b2.iaZ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0704b2.iba = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0704b2.ibb = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0704b2.ibc = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0704b2.ibd = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0704b2.ibe = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0704b2.ibf = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0704b2.ibg = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0704b2.ibh = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0704b2.ibi = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0704b2.ibj = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0704b2.ibk = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0704b2.ibl = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0704b2.ibm = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0704b2.ibn = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0704b2.ibo = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0704b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0704b = c0704b2;
        } else {
            c0704b = (C0704b) view.getTag();
        }
        a(c0704b);
        if (aVar != null) {
            if (aVar.xN(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xN = aVar.xN(0);
                c0704b.ibc.setVisibility(0);
                c0704b.iaZ.setText(xN.cpU() == null ? "" : xN.cpU());
                if (xN.cpV() != null) {
                    c0704b.iba.setDefaultBgResource(R.color.transparent);
                    c0704b.iba.startLoad(xN.cpV(), 10, false);
                }
                c(c0704b.ibb, xN.cpW());
                b(c0704b.iba, xN.cpW());
                a(c0704b.ibd, xN.cqa(), xN.price);
                c0704b.ibc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaW != null) {
                            b.this.iaW.a(aVar.xN(0));
                        }
                    }
                });
            } else {
                c0704b.ibc.setVisibility(4);
                c0704b.ibc.setOnClickListener(null);
            }
            if (aVar.xN(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xN2 = aVar.xN(1);
                c0704b.ibh.setVisibility(0);
                c0704b.ibe.setText(xN2.cpU() == null ? "" : xN2.cpU());
                if (xN2.cpV() != null) {
                    c0704b.ibf.setDefaultBgResource(R.color.transparent);
                    c0704b.ibf.startLoad(xN2.cpV(), 10, false);
                }
                c(c0704b.ibg, xN2.cpW());
                b(c0704b.ibf, xN2.cpW());
                a(c0704b.ibi, xN2.cqa(), xN2.price);
                c0704b.ibh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaW != null) {
                            b.this.iaW.a(aVar.xN(1));
                        }
                    }
                });
            } else {
                c0704b.ibh.setVisibility(4);
                c0704b.ibh.setOnClickListener(null);
            }
            if (aVar.xN(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xN3 = aVar.xN(2);
                c0704b.ibm.setVisibility(0);
                c0704b.ibj.setText(xN3.cpU() == null ? "" : xN3.cpU());
                if (xN3.cpV() != null) {
                    c0704b.ibk.setDefaultBgResource(R.color.transparent);
                    c0704b.ibk.startLoad(xN3.cpV(), 10, false);
                }
                c(c0704b.ibl, xN3.cpW());
                b(c0704b.ibk, xN3.cpW());
                a(c0704b.ibn, xN3.cqa(), xN3.price);
                c0704b.ibm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaW != null) {
                            b.this.iaW.a(aVar.xN(2));
                        }
                    }
                });
            } else {
                c0704b.ibm.setVisibility(4);
                c0704b.ibm.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0704b.ibo.setVisibility(0);
            } else {
                c0704b.ibo.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cpQ() != null) {
                c0704b.title.setVisibility(0);
                c0704b.title.setText(aVar.cpQ());
            } else {
                c0704b.title.setVisibility(8);
            }
        }
        view.setTag(c0704b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eXu.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0704b c0704b) {
        if (c0704b != null) {
            ao.setViewTextColor(c0704b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.iaZ, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.ibe, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.ibj, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.ibd, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.ibi, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0704b.ibn, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0704b.iba.setDefaultResource(R.drawable.pic_live_honor_1);
                c0704b.ibf.setDefaultResource(R.drawable.pic_live_honor_1);
                c0704b.ibk.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0704b.iba.setDefaultResource(R.drawable.pic_live_honor);
                c0704b.ibf.setDefaultResource(R.drawable.pic_live_honor);
                c0704b.ibk.setDefaultResource(R.drawable.pic_live_honor);
            }
            ao.setBackgroundColor(c0704b.ibo, R.color.CAM_X0204);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ao.setViewTextColor(textView, R.color.CAM_X0109);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ao.setViewTextColor(textView, R.color.live_cp_other_b);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ao.setViewTextColor(textView, R.color.CAM_X0302);
                ao.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ao.setViewTextColor(textView, R.color.CAM_X0109);
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
            this.list = cP(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cP(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].IU(list.get(i3).cpQ());
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
                        aVar.IU(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cpQ());
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
    /* loaded from: classes10.dex */
    public class C0704b {
        TextView iaZ;
        TbImageView iba;
        TextView ibb;
        RelativeLayout ibc;
        TextView ibd;
        TextView ibe;
        TbImageView ibf;
        TextView ibg;
        RelativeLayout ibh;
        TextView ibi;
        TextView ibj;
        TbImageView ibk;
        TextView ibl;
        RelativeLayout ibm;
        TextView ibn;
        View ibo;
        TextView title;

        private C0704b() {
        }
    }
}
