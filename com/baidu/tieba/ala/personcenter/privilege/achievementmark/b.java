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
    private a iaY;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eUY = null;
        this.eUY = tbPageContext;
        this.iaY = aVar;
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
        C0688b c0688b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0688b c0688b2 = new C0688b();
            c0688b2.ibb = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0688b2.ibc = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0688b2.ibd = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0688b2.ibe = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0688b2.ibf = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0688b2.ibg = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0688b2.ibh = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0688b2.ibi = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0688b2.ibj = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0688b2.ibk = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0688b2.ibl = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0688b2.ibm = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0688b2.ibn = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0688b2.ibo = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0688b2.ibp = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0688b2.him = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0688b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0688b = c0688b2;
        } else {
            c0688b = (C0688b) view.getTag();
        }
        a(c0688b);
        if (aVar != null) {
            if (aVar.ws(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws = aVar.ws(0);
                c0688b.ibe.setVisibility(0);
                c0688b.ibb.setText(ws.cnh() == null ? "" : ws.cnh());
                if (ws.cni() != null) {
                    c0688b.ibc.setDefaultBgResource(R.color.transparent);
                    c0688b.ibc.startLoad(ws.cni(), 10, false);
                }
                d(c0688b.ibd, ws.cnj());
                b(c0688b.ibc, ws.cnj());
                a(c0688b.ibf, ws.cnn(), ws.price);
                c0688b.ibe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaY != null) {
                            b.this.iaY.a(aVar.ws(0));
                        }
                    }
                });
            } else {
                c0688b.ibe.setVisibility(4);
                c0688b.ibe.setOnClickListener(null);
            }
            if (aVar.ws(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws2 = aVar.ws(1);
                c0688b.ibj.setVisibility(0);
                c0688b.ibg.setText(ws2.cnh() == null ? "" : ws2.cnh());
                if (ws2.cni() != null) {
                    c0688b.ibh.setDefaultBgResource(R.color.transparent);
                    c0688b.ibh.startLoad(ws2.cni(), 10, false);
                }
                d(c0688b.ibi, ws2.cnj());
                b(c0688b.ibh, ws2.cnj());
                a(c0688b.ibk, ws2.cnn(), ws2.price);
                c0688b.ibj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaY != null) {
                            b.this.iaY.a(aVar.ws(1));
                        }
                    }
                });
            } else {
                c0688b.ibj.setVisibility(4);
                c0688b.ibj.setOnClickListener(null);
            }
            if (aVar.ws(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b ws3 = aVar.ws(2);
                c0688b.ibo.setVisibility(0);
                c0688b.ibl.setText(ws3.cnh() == null ? "" : ws3.cnh());
                if (ws3.cni() != null) {
                    c0688b.ibm.setDefaultBgResource(R.color.transparent);
                    c0688b.ibm.startLoad(ws3.cni(), 10, false);
                }
                d(c0688b.ibn, ws3.cnj());
                b(c0688b.ibm, ws3.cnj());
                a(c0688b.ibp, ws3.cnn(), ws3.price);
                c0688b.ibo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.iaY != null) {
                            b.this.iaY.a(aVar.ws(2));
                        }
                    }
                });
            } else {
                c0688b.ibo.setVisibility(4);
                c0688b.ibo.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0688b.him.setVisibility(0);
            } else {
                c0688b.him.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cnd() != null) {
                c0688b.title.setVisibility(0);
                c0688b.title.setText(aVar.cnd());
            } else {
                c0688b.title.setVisibility(8);
            }
        }
        view.setTag(c0688b);
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

    private void a(C0688b c0688b) {
        if (c0688b != null) {
            ap.setViewTextColor(c0688b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibb, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibg, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibl, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibf, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibk, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0688b.ibp, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0688b.ibc.setDefaultResource(R.drawable.pic_live_honor_1);
                c0688b.ibh.setDefaultResource(R.drawable.pic_live_honor_1);
                c0688b.ibm.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0688b.ibc.setDefaultResource(R.drawable.pic_live_honor);
                c0688b.ibh.setDefaultResource(R.drawable.pic_live_honor);
                c0688b.ibm.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0688b.him, R.color.CAM_X0204);
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
                bVarArr[i4 / 3][i4 % 3].Io(list.get(i3).cnd());
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
                        aVar.Io(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cnd());
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
    public class C0688b {
        View him;
        TextView ibb;
        TbImageView ibc;
        TextView ibd;
        RelativeLayout ibe;
        TextView ibf;
        TextView ibg;
        TbImageView ibh;
        TextView ibi;
        RelativeLayout ibj;
        TextView ibk;
        TextView ibl;
        TbImageView ibm;
        TextView ibn;
        RelativeLayout ibo;
        TextView ibp;
        TextView title;

        private C0688b() {
        }
    }
}
