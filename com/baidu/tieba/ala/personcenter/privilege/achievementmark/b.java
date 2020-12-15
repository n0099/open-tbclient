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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eNx;
    private a hOB;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eNx = null;
        this.eNx = tbPageContext;
        this.hOB = aVar;
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
        C0712b c0712b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0712b c0712b2 = new C0712b();
            c0712b2.hOE = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0712b2.hOF = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0712b2.hOG = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0712b2.hOH = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0712b2.hOI = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0712b2.hOJ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0712b2.hOK = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0712b2.hOL = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0712b2.hOM = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0712b2.hON = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0712b2.hOO = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0712b2.hOP = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0712b2.hOQ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0712b2.hOR = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0712b2.hOS = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0712b2.hOT = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0712b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0712b = c0712b2;
        } else {
            c0712b = (C0712b) view.getTag();
        }
        a(c0712b);
        if (aVar != null) {
            if (aVar.xA(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xA = aVar.xA(0);
                c0712b.hOH.setVisibility(0);
                c0712b.hOE.setText(xA.cnb() == null ? "" : xA.cnb());
                if (xA.cnc() != null) {
                    c0712b.hOF.setDefaultBgResource(R.color.transparent);
                    c0712b.hOF.startLoad(xA.cnc(), 10, false);
                }
                c(c0712b.hOG, xA.cnd());
                b(c0712b.hOF, xA.cnd());
                a(c0712b.hOI, xA.cnh(), xA.price);
                c0712b.hOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hOB != null) {
                            b.this.hOB.a(aVar.xA(0));
                        }
                    }
                });
            } else {
                c0712b.hOH.setVisibility(4);
                c0712b.hOH.setOnClickListener(null);
            }
            if (aVar.xA(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xA2 = aVar.xA(1);
                c0712b.hOM.setVisibility(0);
                c0712b.hOJ.setText(xA2.cnb() == null ? "" : xA2.cnb());
                if (xA2.cnc() != null) {
                    c0712b.hOK.setDefaultBgResource(R.color.transparent);
                    c0712b.hOK.startLoad(xA2.cnc(), 10, false);
                }
                c(c0712b.hOL, xA2.cnd());
                b(c0712b.hOK, xA2.cnd());
                a(c0712b.hON, xA2.cnh(), xA2.price);
                c0712b.hOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hOB != null) {
                            b.this.hOB.a(aVar.xA(1));
                        }
                    }
                });
            } else {
                c0712b.hOM.setVisibility(4);
                c0712b.hOM.setOnClickListener(null);
            }
            if (aVar.xA(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b xA3 = aVar.xA(2);
                c0712b.hOR.setVisibility(0);
                c0712b.hOO.setText(xA3.cnb() == null ? "" : xA3.cnb());
                if (xA3.cnc() != null) {
                    c0712b.hOP.setDefaultBgResource(R.color.transparent);
                    c0712b.hOP.startLoad(xA3.cnc(), 10, false);
                }
                c(c0712b.hOQ, xA3.cnd());
                b(c0712b.hOP, xA3.cnd());
                a(c0712b.hOS, xA3.cnh(), xA3.price);
                c0712b.hOR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hOB != null) {
                            b.this.hOB.a(aVar.xA(2));
                        }
                    }
                });
            } else {
                c0712b.hOR.setVisibility(4);
                c0712b.hOR.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0712b.hOT.setVisibility(0);
            } else {
                c0712b.hOT.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cmX() != null) {
                c0712b.title.setVisibility(0);
                c0712b.title.setText(aVar.cmX());
            } else {
                c0712b.title.setVisibility(8);
            }
        }
        view.setTag(c0712b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eNx.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0712b c0712b) {
        if (c0712b != null) {
            ap.setViewTextColor(c0712b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hOE, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hOJ, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hOO, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hOI, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hON, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0712b.hOS, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0712b.hOF.setDefaultResource(R.drawable.pic_live_honor_1);
                c0712b.hOF.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0712b.hOK.setDefaultResource(R.drawable.pic_live_honor_1);
                c0712b.hOK.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0712b.hOP.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0712b.hOF.setDefaultResource(R.drawable.pic_live_honor);
                c0712b.hOF.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0712b.hOK.setDefaultResource(R.drawable.pic_live_honor);
                c0712b.hOK.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0712b.hOP.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0712b.hOT, R.color.CAM_X0204);
        }
    }

    private void c(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ap.setViewTextColor(textView, (int) R.color.CAM_X0109);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ap.setViewTextColor(textView, (int) R.color.live_cp_other_b);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ap.setViewTextColor(textView, (int) R.color.CAM_X0302);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ap.setViewTextColor(textView, (int) R.color.CAM_X0109);
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
            this.list = cI(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cI(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].IX(list.get(i3).cmX());
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
                        aVar.IX(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cmX());
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
    /* loaded from: classes6.dex */
    public class C0712b {
        TextView hOE;
        TbImageView hOF;
        TextView hOG;
        RelativeLayout hOH;
        TextView hOI;
        TextView hOJ;
        TbImageView hOK;
        TextView hOL;
        RelativeLayout hOM;
        TextView hON;
        TextView hOO;
        TbImageView hOP;
        TextView hOQ;
        RelativeLayout hOR;
        TextView hOS;
        View hOT;
        TextView title;

        private C0712b() {
        }
    }
}
