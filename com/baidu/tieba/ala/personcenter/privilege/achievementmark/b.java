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
    private TbPageContext<?> eGu;
    private a hES;
    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> list;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public b(TbPageContext<?> tbPageContext, a aVar) {
        this.eGu = null;
        this.eGu = tbPageContext;
        this.hES = aVar;
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
        C0699b c0699b;
        final com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a aVar = this.list.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
            C0699b c0699b2 = new C0699b();
            c0699b2.hEV = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
            c0699b2.hEW = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
            c0699b2.hEX = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
            c0699b2.hEY = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
            c0699b2.hEZ = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
            c0699b2.hFa = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
            c0699b2.hFb = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
            c0699b2.hFc = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
            c0699b2.hFd = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
            c0699b2.hFe = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
            c0699b2.hFf = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
            c0699b2.hFg = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
            c0699b2.hFh = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
            c0699b2.hFi = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
            c0699b2.hFj = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
            c0699b2.hFk = view.findViewById(R.id.ala_achievement_mark_item_line);
            c0699b2.title = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            c0699b = c0699b2;
        } else {
            c0699b = (C0699b) view.getTag();
        }
        a(c0699b);
        if (aVar != null) {
            if (aVar.wV(0) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wV = aVar.wV(0);
                c0699b.hEY.setVisibility(0);
                c0699b.hEV.setText(wV.cjg() == null ? "" : wV.cjg());
                if (wV.cjh() != null) {
                    c0699b.hEW.setDefaultBgResource(R.color.transparent);
                    c0699b.hEW.startLoad(wV.cjh(), 10, false);
                }
                c(c0699b.hEX, wV.cji());
                b(c0699b.hEW, wV.cji());
                a(c0699b.hEZ, wV.cjm(), wV.price);
                c0699b.hEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hES != null) {
                            b.this.hES.a(aVar.wV(0));
                        }
                    }
                });
            } else {
                c0699b.hEY.setVisibility(4);
                c0699b.hEY.setOnClickListener(null);
            }
            if (aVar.wV(1) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wV2 = aVar.wV(1);
                c0699b.hFd.setVisibility(0);
                c0699b.hFa.setText(wV2.cjg() == null ? "" : wV2.cjg());
                if (wV2.cjh() != null) {
                    c0699b.hFb.setDefaultBgResource(R.color.transparent);
                    c0699b.hFb.startLoad(wV2.cjh(), 10, false);
                }
                c(c0699b.hFc, wV2.cji());
                b(c0699b.hFb, wV2.cji());
                a(c0699b.hFe, wV2.cjm(), wV2.price);
                c0699b.hFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hES != null) {
                            b.this.hES.a(aVar.wV(1));
                        }
                    }
                });
            } else {
                c0699b.hFd.setVisibility(4);
                c0699b.hFd.setOnClickListener(null);
            }
            if (aVar.wV(2) != null) {
                com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b wV3 = aVar.wV(2);
                c0699b.hFi.setVisibility(0);
                c0699b.hFf.setText(wV3.cjg() == null ? "" : wV3.cjg());
                if (wV3.cjh() != null) {
                    c0699b.hFg.setDefaultBgResource(R.color.transparent);
                    c0699b.hFg.startLoad(wV3.cjh(), 10, false);
                }
                c(c0699b.hFh, wV3.cji());
                b(c0699b.hFg, wV3.cji());
                a(c0699b.hFj, wV3.cjm(), wV3.price);
                c0699b.hFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.hES != null) {
                            b.this.hES.a(aVar.wV(2));
                        }
                    }
                });
            } else {
                c0699b.hFi.setVisibility(4);
                c0699b.hFi.setOnClickListener(null);
            }
            if (aVar.getType() == 3 || aVar.getType() == 1) {
                c0699b.hFk.setVisibility(0);
            } else {
                c0699b.hFk.setVisibility(8);
            }
            if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.cjc() != null) {
                c0699b.title.setVisibility(0);
                c0699b.title.setText(aVar.cjc());
            } else {
                c0699b.title.setVisibility(8);
            }
        }
        view.setTag(c0699b);
        return view;
    }

    private void a(TextView textView, boolean z, long j) {
        if (z) {
            textView.setVisibility(0);
            Drawable drawable = this.eGu.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            textView.setCompoundDrawablePadding(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds4));
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

    private void a(C0699b c0699b) {
        if (c0699b != null) {
            ap.setViewTextColor(c0699b.title, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hEV, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hFa, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hFf, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hEZ, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hFe, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            ap.setViewTextColor(c0699b.hFj, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
            if (TbadkApplication.getInst().getSkinType() == 1) {
                c0699b.hEW.setDefaultResource(R.drawable.pic_live_honor_1);
                c0699b.hEW.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0699b.hFb.setDefaultResource(R.drawable.pic_live_honor_1);
                c0699b.hFb.setDefaultErrorResource(R.drawable.pic_live_honor_1);
                c0699b.hFg.setDefaultResource(R.drawable.pic_live_honor_1);
            } else {
                c0699b.hEW.setDefaultResource(R.drawable.pic_live_honor);
                c0699b.hEW.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0699b.hFb.setDefaultResource(R.drawable.pic_live_honor);
                c0699b.hFb.setDefaultErrorResource(R.drawable.pic_live_honor);
                c0699b.hFg.setDefaultResource(R.drawable.pic_live_honor);
            }
            ap.setBackgroundColor(c0699b.hFk, R.color.CAM_X0204);
        }
    }

    private void c(TextView textView, int i) {
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
            this.list = cE(list);
            notifyDataSetChanged();
        }
    }

    private List<com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.a> cE(List<c> list) {
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
                bVarArr[i4 / 3][i4 % 3].Ii(list.get(i3).cjc());
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
                        aVar.Ii(((com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b[][]) arrayList2.get(i6))[0][0].cjc());
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
    public class C0699b {
        TextView hEV;
        TbImageView hEW;
        TextView hEX;
        RelativeLayout hEY;
        TextView hEZ;
        TextView hFa;
        TbImageView hFb;
        TextView hFc;
        RelativeLayout hFd;
        TextView hFe;
        TextView hFf;
        TbImageView hFg;
        TextView hFh;
        RelativeLayout hFi;
        TextView hFj;
        View hFk;
        TextView title;

        private C0699b() {
        }
    }
}
