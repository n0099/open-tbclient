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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private a hWp;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eSJ = null;
        this.eSJ = tbPageContext;
        this.hWp = aVar;
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
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0687b c0687b2 = new C0687b();
            c0687b2.hWs = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0687b2.hWt = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0687b2.hWu = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0687b2.hWv = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0687b2.hWw = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0687b2.hWx = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0687b2.hWy = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0687b2.hWz = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0687b2.hWA = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0687b2.hWB = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0687b2.hWC = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0687b2.hWD = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0687b2.hWE = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0687b2.hWF = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0687b2.hWG = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0687b2.hWH = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0687b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0687b = c0687b2;
        } else {
            c0687b = (C0687b) view.getTag();
        }
        a(c0687b);
        if (aVar != null) {
            if (aVar.wh(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wh = aVar.wh(0);
                c0687b.hWv.setVisibility(0);
                c0687b.hWs.setText(wh.cmc() == null ? "" : wh.cmc());
                if (wh.cmd() != null) {
                    c0687b.hWt.setDefaultBgResource(R.color.transparent);
                    c0687b.hWt.startLoad(wh.cmd(), 10, false);
                }
                c(c0687b.hWu, wh.cme());
                b(c0687b.hWt, wh.cme());
                a(c0687b.hWw, wh.cmi(), wh.price);
                c0687b.hWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hWp != null) {
                            b.this.hWp.a(aVar.wh(0));
                        }
                    }
                });
            } else {
                c0687b.hWv.setVisibility(4);
                c0687b.hWv.setOnClickListener(null);
            }
            if (aVar.wh(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wh2 = aVar.wh(1);
                c0687b.hWA.setVisibility(0);
                c0687b.hWx.setText(wh2.cmc() == null ? "" : wh2.cmc());
                if (wh2.cmd() != null) {
                    c0687b.hWy.setDefaultBgResource(R.color.transparent);
                    c0687b.hWy.startLoad(wh2.cmd(), 10, false);
                }
                c(c0687b.hWz, wh2.cme());
                b(c0687b.hWy, wh2.cme());
                a(c0687b.hWB, wh2.cmi(), wh2.price);
                c0687b.hWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hWp != null) {
                            b.this.hWp.a(aVar.wh(1));
                        }
                    }
                });
            } else {
                c0687b.hWA.setVisibility(4);
                c0687b.hWA.setOnClickListener(null);
            }
            if (aVar.wh(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wh3 = aVar.wh(2);
                c0687b.hWF.setVisibility(0);
                c0687b.hWC.setText(wh3.cmc() == null ? "" : wh3.cmc());
                if (wh3.cmd() != null) {
                    c0687b.hWD.setDefaultBgResource(R.color.transparent);
                    c0687b.hWD.startLoad(wh3.cmd(), 10, false);
                }
                c(c0687b.hWE, wh3.cme());
                b(c0687b.hWD, wh3.cme());
                a(c0687b.hWG, wh3.cmi(), wh3.price);
                c0687b.hWF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hWp != null) {
                            b.this.hWp.a(aVar.wh(2));
                        }
                    }
                });
            } else {
                c0687b.hWF.setVisibility(4);
                c0687b.hWF.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0687b.hWH.setVisibility(0);
            } else {
                c0687b.hWH.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.clY() != null) {
                c0687b.title.setVisibility(0);
                c0687b.title.setText(aVar.clY());
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
            Drawable drawable = this.eSJ.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds4));
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
            ao.setViewTextColor(c0687b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWs, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWx, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWC, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWw, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWB, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ao.setViewTextColor(c0687b.hWG, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0687b.hWt.setDefaultResource(R.drawable.pic_live_honor_1);
                c0687b.hWy.setDefaultResource(R.drawable.pic_live_honor_1);
                c0687b.hWD.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0687b.hWt.setDefaultResource(R.drawable.pic_live_honor);
                c0687b.hWy.setDefaultResource(R.drawable.pic_live_honor);
                c0687b.hWD.setDefaultResource(R.drawable.pic_live_honor);
            }
            ao.setBackgroundColor(c0687b.hWH, R.color.CAM_X0204);
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
                bVarArr[i4 / 3][i4 % 3].HJ(list.get(i3).clY());
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
                        aVar.HJ(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].clY());
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
    public class C0687b {
        RelativeLayout hWA;
        TextView hWB;
        TextView hWC;
        TbImageView hWD;
        TextView hWE;
        RelativeLayout hWF;
        TextView hWG;
        View hWH;
        TextView hWs;
        TbImageView hWt;
        TextView hWu;
        RelativeLayout hWv;
        TextView hWw;
        TextView hWx;
        TbImageView hWy;
        TextView hWz;
        TextView title;

        private C0687b() {
        }
    }
}
