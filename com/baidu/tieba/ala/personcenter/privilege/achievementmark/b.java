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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eWx;
    private a icH;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eWx = null;
        this.eWx = tbPageContext;
        this.icH = aVar;
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
        C0694b c0694b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0694b c0694b2 = new C0694b();
            c0694b2.icK = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0694b2.icL = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0694b2.icM = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0694b2.icN = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0694b2.icO = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0694b2.icP = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0694b2.icQ = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0694b2.icR = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0694b2.icS = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0694b2.icT = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0694b2.icU = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0694b2.icV = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0694b2.icW = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0694b2.icX = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0694b2.icY = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0694b2.hjV = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0694b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0694b = c0694b2;
        } else {
            c0694b = (C0694b) view.getTag();
        }
        a(c0694b);
        if (aVar != null) {
            if (aVar.wt(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wt = aVar.wt(0);
                c0694b.icN.setVisibility(0);
                c0694b.icK.setText(wt.cnn() == null ? "" : wt.cnn());
                if (wt.cno() != null) {
                    c0694b.icL.setDefaultBgResource(R.color.transparent);
                    c0694b.icL.startLoad(wt.cno(), 10, false);
                }
                d(c0694b.icM, wt.cnp());
                b(c0694b.icL, wt.cnp());
                a(c0694b.icO, wt.cnt(), wt.price);
                c0694b.icN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.icH != null) {
                            b.this.icH.a(aVar.wt(0));
                        }
                    }
                });
            } else {
                c0694b.icN.setVisibility(4);
                c0694b.icN.setOnClickListener(null);
            }
            if (aVar.wt(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wt2 = aVar.wt(1);
                c0694b.icS.setVisibility(0);
                c0694b.icP.setText(wt2.cnn() == null ? "" : wt2.cnn());
                if (wt2.cno() != null) {
                    c0694b.icQ.setDefaultBgResource(R.color.transparent);
                    c0694b.icQ.startLoad(wt2.cno(), 10, false);
                }
                d(c0694b.icR, wt2.cnp());
                b(c0694b.icQ, wt2.cnp());
                a(c0694b.icT, wt2.cnt(), wt2.price);
                c0694b.icS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.icH != null) {
                            b.this.icH.a(aVar.wt(1));
                        }
                    }
                });
            } else {
                c0694b.icS.setVisibility(4);
                c0694b.icS.setOnClickListener(null);
            }
            if (aVar.wt(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wt3 = aVar.wt(2);
                c0694b.icX.setVisibility(0);
                c0694b.icU.setText(wt3.cnn() == null ? "" : wt3.cnn());
                if (wt3.cno() != null) {
                    c0694b.icV.setDefaultBgResource(R.color.transparent);
                    c0694b.icV.startLoad(wt3.cno(), 10, false);
                }
                d(c0694b.icW, wt3.cnp());
                b(c0694b.icV, wt3.cnp());
                a(c0694b.icY, wt3.cnt(), wt3.price);
                c0694b.icX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.icH != null) {
                            b.this.icH.a(aVar.wt(2));
                        }
                    }
                });
            } else {
                c0694b.icX.setVisibility(4);
                c0694b.icX.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0694b.hjV.setVisibility(0);
            } else {
                c0694b.hjV.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cnj() != null) {
                c0694b.title.setVisibility(0);
                c0694b.title.setText(aVar.cnj());
            } else {
                c0694b.title.setVisibility(8);
            }
        }
        view.setTag(c0694b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eWx.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0694b c0694b) {
        if (c0694b != null) {
            ap.setViewTextColor(c0694b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icK, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icP, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icU, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icO, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icT, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0694b.icY, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0694b.icL.setDefaultResource(R.drawable.pic_live_honor_1);
                c0694b.icQ.setDefaultResource(R.drawable.pic_live_honor_1);
                c0694b.icV.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0694b.icL.setDefaultResource(R.drawable.pic_live_honor);
                c0694b.icQ.setDefaultResource(R.drawable.pic_live_honor);
                c0694b.icV.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0694b.hjV, R.color.CAM_X0204);
        }
    }

    private void d(TextView textView, int i) {
        if (textView != null) {
            if (i == 0) {
                textView.setText(R.string.ala_achievement_mark_status_unlock);
                ap.setViewTextColor(textView, R.color.CAM_X0109);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
            } else if (i == 1) {
                textView.setText(R.string.ala_achievement_mark_status_wear);
                ap.setViewTextColor(textView, R.color.live_cp_other_b);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
            } else if (i == 2) {
                textView.setText(R.string.ala_achievement_mark_status_lock);
                ap.setViewTextColor(textView, R.color.CAM_X0302);
                ap.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
            } else if (i == 3) {
                textView.setText(R.string.ala_achievement_mark_status_expired);
                ap.setViewTextColor(textView, R.color.CAM_X0109);
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
            this.list = cK(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cK(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Ix(list.get(i3).cnj());
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
                        aVar.Ix(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cnj());
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
    /* loaded from: classes9.dex */
    public class C0694b {
        View hjV;
        TextView icK;
        TbImageView icL;
        TextView icM;
        RelativeLayout icN;
        TextView icO;
        TextView icP;
        TbImageView icQ;
        TextView icR;
        RelativeLayout icS;
        TextView icT;
        TextView icU;
        TbImageView icV;
        TextView icW;
        RelativeLayout icX;
        TextView icY;
        TextView title;

        private C0694b() {
        }
    }
}
