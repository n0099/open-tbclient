package com.baidu.tieba.discover.memberprivilege;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private MemberPrivilegeActivity apI;
    private int apJ;
    private boolean apK = false;
    private ArrayList<Object> apL = new ArrayList<>();

    public j(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.apI = memberPrivilegeActivity;
    }

    public void a(a aVar) {
        this.apL.clear();
        if (aVar != null && aVar.apo != null && aVar.apq != null) {
            List<d> list = aVar.apq;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.apo);
            for (d dVar : list) {
                if (dVar != null && !TextUtils.isEmpty(dVar.mClassName) && dVar.apv != null && dVar.apv.size() != 0 && n(dVar.apv)) {
                    arrayList.add(dVar.mClassName);
                    Iterator<b> it = dVar.apv.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.apL.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean n(ArrayList<b> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        o(arrayList);
        return arrayList.size() > 0;
    }

    public void o(ArrayList<b> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.abu) && TextUtils.getTrimmedLength(next.abu) > 0) {
                    arrayList2.add(next);
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apL == null) {
            return 0;
        }
        return this.apL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.apL == null || i < 0 || i >= this.apL.size()) {
            return null;
        }
        return this.apL.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.apL == null || i < 0 || i > getCount() || i >= this.apL.size()) {
            return 3;
        }
        Object obj = this.apL.get(i);
        if (obj instanceof f) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof b ? 2 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return b(i, view, viewGroup);
        }
        if (itemViewType == 1) {
            return a(i, view, viewGroup);
        }
        if (itemViewType == 2) {
            return c(i, view, viewGroup);
        }
        if (itemViewType == 3) {
        }
        return null;
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        m mVar;
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof m)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apI, w.memberprivilege_titleview, null);
            mVar = new m(null);
            mVar.aqc = (TextView) view.findViewById(v.title_view);
            view.setTag(mVar);
        } else {
            mVar = (m) view.getTag();
        }
        mVar.aqc.setText((String) getItem(i));
        this.apI.getLayoutMode().L(z);
        this.apI.getLayoutMode().h(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        k kVar;
        f fVar;
        c cVar;
        e eVar;
        String string;
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof k)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apI, w.memberprivilege_headview, null);
            kVar = new k(null);
            kVar.apM = (HeadImageView) view.findViewById(v.head_portrait);
            kVar.apN = (RelativeLayout) view.findViewById(v.nonmember_stamp);
            kVar.apQ = (TextView) view.findViewById(v.nonmembername);
            kVar.apO = (RelativeLayout) view.findViewById(v.member_stamp);
            kVar.apP = (TextView) view.findViewById(v.membername);
            kVar.apR = (TbImageView) view.findViewById(v.membericon);
            kVar.apV = (ImageView) view.findViewById(v.vip_bean_icon);
            kVar.apW = (ImageView) view.findViewById(v.nonmember_bean_icon);
            kVar.apX = (TextView) view.findViewById(v.vip_tbean_num);
            kVar.apY = (TextView) view.findViewById(v.nonmember_tbean_num);
            kVar.apS = (TextView) view.findViewById(v.endtime);
            kVar.apT = (TextView) view.findViewById(v.left_button);
            kVar.apU = (TextView) view.findViewById(v.right_button);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        if (getItem(i) == null || (fVar = (f) getItem(i)) == null || (cVar = fVar.apD) == null || (eVar = fVar.apE) == null) {
            return null;
        }
        long j = eVar.apy + eVar.apz;
        this.apJ = (int) cVar.aoI;
        long j2 = cVar.aps;
        String a = a(j2, cVar.apt);
        kVar.apM.c(fVar.mPortrait, 12, false);
        aw.h(kVar.apM, u.memberinfo_bg_shape);
        if (!eVar.isValid()) {
            j = 0;
        }
        if (cVar.isValid() && eVar.isValid()) {
            kVar.apN.setVisibility(8);
            kVar.apO.setVisibility(0);
            kVar.apR.c(fVar.apD.apu, 21, false);
            if (this.apK) {
                kVar.apS.setText(eF(a));
            } else {
                if (1 == this.apJ) {
                    string = this.apI.getString(y.member);
                } else {
                    string = this.apI.getString(y.vip_member);
                }
                kVar.apS.setText(this.apI.getString(y.endtiem_memeber_tip, new Object[]{string, az.e(new Date(j2 * 1000))}));
                aw.b(kVar.apS, s.cp_cont_i, 1);
            }
            kVar.apP.setText(fVar.mName);
            kVar.apT.setText(this.apJ == 1 ? y.continue_member : y.continue_vip_member);
            kVar.apT.setOnClickListener(this.apI);
            kVar.apX.setText(String.valueOf(j));
            aw.c(kVar.apV, u.icon_vip_dou);
        } else {
            kVar.apN.setVisibility(0);
            kVar.apO.setVisibility(8);
            kVar.apQ.setText(fVar.mName);
            kVar.apT.setText(y.dredge_member);
            kVar.apT.setOnClickListener(this.apI);
            kVar.apY.setText(String.valueOf(j));
            aw.c(kVar.apW, u.icon_vip_dou);
        }
        aw.h((View) kVar.apS, u.bg_dredge_tips);
        kVar.apU.setOnClickListener(this.apI);
        this.apI.getLayoutMode().L(z);
        this.apI.getLayoutMode().h(view);
        return view;
    }

    private String a(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.apK = true;
        if (0 < j3 && j3 <= 86400) {
            return this.apI.getString(y.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT;
        }
        return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
    }

    private SpannableString eF(String str) {
        SpannableString spannableString = new SpannableString(this.apI.getString(y.endtime_days_tip, new Object[]{str}));
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_other_b)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 5, 16, 33);
        return spannableString;
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        l lVar;
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apI, w.memberprivilege_item, null);
            lVar = new l(null);
            lVar.apZ = (HeadImageView) view.findViewById(v.item_portrait);
            lVar.JN = (TextView) view.findViewById(v.title);
            lVar.aqa = (TextView) view.findViewById(v.description);
            lVar.aqb = (ImageView) view.findViewById(v.divide_line_top);
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            lVar.aqb.setVisibility(8);
        }
        b bVar = (b) getItem(i);
        lVar.apZ.c(bVar.apr, 10, false);
        lVar.apZ.setSupportNoImage(false);
        lVar.JN.setText(bVar.mTitle);
        lVar.aqa.setText(bVar.zL);
        this.apI.getLayoutMode().L(z);
        this.apI.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
