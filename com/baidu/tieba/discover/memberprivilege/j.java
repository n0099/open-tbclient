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
import com.baidu.tbadk.core.util.ay;
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
    private int apA;
    private boolean apB = false;
    private ArrayList<Object> apC = new ArrayList<>();
    private MemberPrivilegeActivity apz;

    public j(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.apz = memberPrivilegeActivity;
    }

    public void a(a aVar) {
        this.apC.clear();
        if (aVar != null && aVar.apf != null && aVar.apg != null) {
            List<d> list = aVar.apg;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.apf);
            for (d dVar : list) {
                if (dVar != null && !TextUtils.isEmpty(dVar.mClassName) && dVar.apl != null && dVar.apl.size() != 0 && m(dVar.apl)) {
                    arrayList.add(dVar.mClassName);
                    Iterator<b> it = dVar.apl.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.apC.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean m(ArrayList<b> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        n(arrayList);
        return arrayList.size() > 0;
    }

    public void n(ArrayList<b> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.abo) && TextUtils.getTrimmedLength(next.abo) > 0) {
                    arrayList2.add(next);
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apC == null) {
            return 0;
        }
        return this.apC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.apC == null || i < 0 || i >= this.apC.size()) {
            return null;
        }
        return this.apC.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.apC == null || i < 0 || i > getCount() || i >= this.apC.size()) {
            return 3;
        }
        Object obj = this.apC.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apz, w.memberprivilege_titleview, null);
            mVar = new m(null);
            mVar.apT = (TextView) view.findViewById(v.title_view);
            view.setTag(mVar);
        } else {
            mVar = (m) view.getTag();
        }
        mVar.apT.setText((String) getItem(i));
        this.apz.getLayoutMode().L(z);
        this.apz.getLayoutMode().h(view);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apz, w.memberprivilege_headview, null);
            kVar = new k(null);
            kVar.apD = (HeadImageView) view.findViewById(v.head_portrait);
            kVar.apE = (RelativeLayout) view.findViewById(v.nonmember_stamp);
            kVar.apH = (TextView) view.findViewById(v.nonmembername);
            kVar.apF = (RelativeLayout) view.findViewById(v.member_stamp);
            kVar.apG = (TextView) view.findViewById(v.membername);
            kVar.apI = (TbImageView) view.findViewById(v.membericon);
            kVar.apM = (ImageView) view.findViewById(v.vip_bean_icon);
            kVar.apN = (ImageView) view.findViewById(v.nonmember_bean_icon);
            kVar.apO = (TextView) view.findViewById(v.vip_tbean_num);
            kVar.apP = (TextView) view.findViewById(v.nonmember_tbean_num);
            kVar.apJ = (TextView) view.findViewById(v.endtime);
            kVar.apK = (TextView) view.findViewById(v.left_button);
            kVar.apL = (TextView) view.findViewById(v.right_button);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        if (getItem(i) == null || (fVar = (f) getItem(i)) == null || (cVar = fVar.apu) == null || (eVar = fVar.apv) == null) {
            return null;
        }
        long j = eVar.apo + eVar.apq;
        this.apA = (int) cVar.aoz;
        long j2 = cVar.api;
        String a = a(j2, cVar.apj);
        kVar.apD.c(fVar.mPortrait, 12, false);
        aw.h(kVar.apD, u.memberinfo_bg_shape);
        if (!eVar.isValid()) {
            j = 0;
        }
        if (cVar.isValid() && eVar.isValid()) {
            kVar.apE.setVisibility(8);
            kVar.apF.setVisibility(0);
            kVar.apI.c(fVar.apu.apk, 21, false);
            if (this.apB) {
                kVar.apJ.setText(eF(a));
            } else {
                if (1 == this.apA) {
                    string = this.apz.getString(y.member);
                } else {
                    string = this.apz.getString(y.vip_member);
                }
                kVar.apJ.setText(this.apz.getString(y.endtiem_memeber_tip, new Object[]{string, ay.e(new Date(j2 * 1000))}));
                aw.b(kVar.apJ, s.cp_cont_i, 1);
            }
            kVar.apG.setText(fVar.mName);
            kVar.apK.setText(this.apA == 1 ? y.continue_member : y.continue_vip_member);
            kVar.apK.setOnClickListener(this.apz);
            kVar.apO.setText(String.valueOf(j));
            aw.c(kVar.apM, u.icon_vip_dou);
        } else {
            kVar.apE.setVisibility(0);
            kVar.apF.setVisibility(8);
            kVar.apH.setText(fVar.mName);
            kVar.apK.setText(y.dredge_member);
            kVar.apK.setOnClickListener(this.apz);
            kVar.apP.setText(String.valueOf(j));
            aw.c(kVar.apN, u.icon_vip_dou);
        }
        aw.h((View) kVar.apJ, u.bg_dredge_tips);
        kVar.apL.setOnClickListener(this.apz);
        this.apz.getLayoutMode().L(z);
        this.apz.getLayoutMode().h(view);
        return view;
    }

    private String a(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.apB = true;
        if (0 < j3 && j3 <= 86400) {
            return this.apz.getString(y.today);
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
        SpannableString spannableString = new SpannableString(this.apz.getString(y.endtime_days_tip, new Object[]{str}));
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_other_b)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 5, 16, 33);
        return spannableString;
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        l lVar;
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.apz, w.memberprivilege_item, null);
            lVar = new l(null);
            lVar.apQ = (HeadImageView) view.findViewById(v.item_portrait);
            lVar.JM = (TextView) view.findViewById(v.title);
            lVar.apR = (TextView) view.findViewById(v.description);
            lVar.apS = (ImageView) view.findViewById(v.divide_line_top);
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            lVar.apS.setVisibility(8);
        }
        b bVar = (b) getItem(i);
        lVar.apQ.c(bVar.aph, 10, false);
        lVar.apQ.setSupportNoImage(false);
        lVar.JM.setText(bVar.mTitle);
        lVar.apR.setText(bVar.zL);
        this.apz.getLayoutMode().L(z);
        this.apz.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
