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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eUY;
    private a iaK;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eUY = null;
        this.eUY = tbPageContext;
        this.iaK = aVar;
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
        C0687b c0687b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0687b c0687b2 = new C0687b();
            c0687b2.iaN = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0687b2.iaO = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0687b2.iaP = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0687b2.iaQ = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0687b2.iaR = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0687b2.iaS = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0687b2.iaT = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0687b2.iaU = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0687b2.iaV = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0687b2.iaW = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0687b2.iaX = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0687b2.iaY = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0687b2.iaZ = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0687b2.iba = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0687b2.ibb = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0687b2.hhX = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0687b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0687b = c0687b2;
        } else {
            c0687b = (C0687b) view.getTag();
        }
        a(c0687b);
        if (aVar != null) {
            if (aVar.ws(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws = aVar.ws(0);
                c0687b.iaQ.setVisibility(0);
                c0687b.iaN.setText(ws.cna() == null ? "" : ws.cna());
                if (ws.cnb() != null) {
                    c0687b.iaO.setDefaultBgResource(R.color.transparent);
                    c0687b.iaO.startLoad(ws.cnb(), 10, false);
                }
                d(c0687b.iaP, ws.cnc());
                b(c0687b.iaO, ws.cnc());
                a(c0687b.iaR, ws.cng(), ws.price);
                c0687b.iaQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaK != null) {
                            b.this.iaK.a(aVar.ws(0));
                        }
                    }
                });
            } else {
                c0687b.iaQ.setVisibility(4);
                c0687b.iaQ.setOnClickListener(null);
            }
            if (aVar.ws(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws2 = aVar.ws(1);
                c0687b.iaV.setVisibility(0);
                c0687b.iaS.setText(ws2.cna() == null ? "" : ws2.cna());
                if (ws2.cnb() != null) {
                    c0687b.iaT.setDefaultBgResource(R.color.transparent);
                    c0687b.iaT.startLoad(ws2.cnb(), 10, false);
                }
                d(c0687b.iaU, ws2.cnc());
                b(c0687b.iaT, ws2.cnc());
                a(c0687b.iaW, ws2.cng(), ws2.price);
                c0687b.iaV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaK != null) {
                            b.this.iaK.a(aVar.ws(1));
                        }
                    }
                });
            } else {
                c0687b.iaV.setVisibility(4);
                c0687b.iaV.setOnClickListener(null);
            }
            if (aVar.ws(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws3 = aVar.ws(2);
                c0687b.iba.setVisibility(0);
                c0687b.iaX.setText(ws3.cna() == null ? "" : ws3.cna());
                if (ws3.cnb() != null) {
                    c0687b.iaY.setDefaultBgResource(R.color.transparent);
                    c0687b.iaY.startLoad(ws3.cnb(), 10, false);
                }
                d(c0687b.iaZ, ws3.cnc());
                b(c0687b.iaY, ws3.cnc());
                a(c0687b.ibb, ws3.cng(), ws3.price);
                c0687b.iba.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaK != null) {
                            b.this.iaK.a(aVar.ws(2));
                        }
                    }
                });
            } else {
                c0687b.iba.setVisibility(4);
                c0687b.iba.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0687b.hhX.setVisibility(0);
            } else {
                c0687b.hhX.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cmW() != null) {
                c0687b.title.setVisibility(0);
                c0687b.title.setText(aVar.cmW());
            } else {
                c0687b.title.setVisibility(8);
            }
        }
        view.setTag(c0687b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eUY.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0687b c0687b) {
        if (c0687b != null) {
            ap.setViewTextColor(c0687b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.iaN, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.iaS, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.iaX, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.iaR, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.iaW, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0687b.ibb, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0687b.iaO.setDefaultResource(R.drawable.pic_live_honor_1);
                c0687b.iaT.setDefaultResource(R.drawable.pic_live_honor_1);
                c0687b.iaY.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0687b.iaO.setDefaultResource(R.drawable.pic_live_honor);
                c0687b.iaT.setDefaultResource(R.drawable.pic_live_honor);
                c0687b.iaY.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0687b.hhX, R.color.CAM_X0204);
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
                bVarArr[i4 / 3][i4 % 3].In(list.get(i3).cmW());
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
                        aVar.In(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cmW());
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
    public class C0687b {
        View hhX;
        TextView iaN;
        TbImageView iaO;
        TextView iaP;
        RelativeLayout iaQ;
        TextView iaR;
        TextView iaS;
        TbImageView iaT;
        TextView iaU;
        RelativeLayout iaV;
        TextView iaW;
        TextView iaX;
        TbImageView iaY;
        TextView iaZ;
        RelativeLayout iba;
        TextView ibb;
        TextView title;

        private C0687b() {
        }
    }
}
