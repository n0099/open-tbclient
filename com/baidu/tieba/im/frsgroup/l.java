package com.baidu.tieba.im.frsgroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private final MembersActivity iBR;
    private a iBS;
    private boolean iBT;
    private boolean iBV;
    private final Set<Long> iBW = new HashSet();
    private final List<UserData> iBX = new ArrayList();
    private ArrayList<IconData> iBY = null;
    private boolean iBU = false;

    /* loaded from: classes10.dex */
    public interface a {
        void xI(int i);
    }

    public void a(a aVar) {
        this.iBS = aVar;
    }

    public void dh(List<UserData> list) {
        this.iBX.addAll(list);
    }

    public void di(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.iBX.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cmJ() {
        this.iBW.clear();
    }

    public Set<Long> cmK() {
        return this.iBW;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.iBW.contains(l)) {
                this.iBW.remove(l);
            } else {
                this.iBW.add(l);
            }
            notifyDataSetChanged();
            if (this.iBS != null) {
                this.iBS.xI(this.iBW.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.iBX.clear();
        }
        this.iBU = false;
        this.iBT = true;
    }

    public l(MembersActivity membersActivity) {
        this.iBR = membersActivity;
    }

    public void pf(boolean z) {
        this.iBT = z;
    }

    public boolean cmL() {
        return this.iBT;
    }

    public void pg(boolean z) {
        this.iBU = z;
    }

    public boolean cjS() {
        return this.iBV;
    }

    public void ph(boolean z) {
        this.iBV = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iBX != null) {
            int size = this.iBX.size();
            if (this.iBU) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.iBX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.iBU && i == getCount() - 1) {
            return -2L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (this.iBX != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.iBR.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.iCa = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.iCb = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.iCc = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.iBR.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.iCe = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.iCe.setIsRound(false);
                    bVar2.iCe.setAutoChangeStyle(true);
                    bVar2.iAS = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.iCf = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.iCg = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.iCh = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.iCd = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.agz = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.iCi = inflate2.findViewById(R.id.list_line);
                    bVar2.iCj = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.iCi.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.iCj.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.iBT) {
                    bVar.iCb.setText(R.string.members_load_more_person);
                    bVar.iCc.setVisibility(0);
                } else {
                    bVar.iCb.setText(R.string.members_no_more_person);
                    bVar.iCc.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.iCe.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.iCe.startLoad(portrait, 12, false);
                    }
                    bVar.iAS.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.iCf.setVisibility(0);
                            am.setImageResource(bVar.iCf, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.iCf.setVisibility(0);
                            am.setImageResource(bVar.iCf, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.iCf.setVisibility(8);
                            break;
                    }
                    bVar.iCg.setText(c(userData));
                    bVar.iCh.setText(userData.getPosition());
                    this.iBY = userData.getTShowInfo();
                    if (bVar.agz != null) {
                        bVar.agz.a(this.iBY, 2, this.iBR.getResources().getDimensionPixelSize(R.dimen.ds38), this.iBR.getResources().getDimensionPixelSize(R.dimen.ds38), this.iBR.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.iBV) {
                        bVar.iCd.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.iCd.setTag(valueOf);
                        bVar.iCd.setSelected(this.iBW.contains(valueOf));
                        bVar.iCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.iBW.add(l);
                                    } else {
                                        l.this.iBW.remove(l);
                                    }
                                    if (l.this.iBS != null) {
                                        l.this.iBS.xI(l.this.iBW.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.iCd.setVisibility(8);
                    }
                    cf(view);
                }
            }
        }
        return view;
    }

    private void cf(View view) {
        this.iBR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iBR.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cmD = this.iBR.cmD();
        switch (cmD.getOrderType()) {
            case 0:
                lastReplyTime = userData.getLoginTime();
                break;
            case 1:
                lastReplyTime = userData.getLastReplyTime();
                break;
            case 2:
                lastReplyTime = userData.getInTime();
                break;
            default:
                lastReplyTime = 0;
                break;
        }
        if (lastReplyTime <= 0) {
            if (cmD.getOrderType() == 1) {
                return this.iBR.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox agz = null;
        TextView iAS;
        LinearLayout iCa;
        TextView iCb;
        ProgressBar iCc;
        ImageView iCd;
        HeadImageView iCe;
        ImageView iCf;
        TextView iCg;
        TextView iCh;
        View iCi;
        View iCj;

        b() {
        }
    }
}
