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
    private final MembersActivity iBe;
    private a iBf;
    private boolean iBg;
    private boolean iBi;
    private final Set<Long> iBj = new HashSet();
    private final List<UserData> iBk = new ArrayList();
    private ArrayList<IconData> iBl = null;
    private boolean iBh = false;

    /* loaded from: classes10.dex */
    public interface a {
        void xG(int i);
    }

    public void a(a aVar) {
        this.iBf = aVar;
    }

    public void dg(List<UserData> list) {
        this.iBk.addAll(list);
    }

    public void dh(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.iBk.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cmA() {
        this.iBj.clear();
    }

    public Set<Long> cmB() {
        return this.iBj;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.iBj.contains(l)) {
                this.iBj.remove(l);
            } else {
                this.iBj.add(l);
            }
            notifyDataSetChanged();
            if (this.iBf != null) {
                this.iBf.xG(this.iBj.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.iBk.clear();
        }
        this.iBh = false;
        this.iBg = true;
    }

    public l(MembersActivity membersActivity) {
        this.iBe = membersActivity;
    }

    public void pf(boolean z) {
        this.iBg = z;
    }

    public boolean cmC() {
        return this.iBg;
    }

    public void pg(boolean z) {
        this.iBh = z;
    }

    public boolean cjJ() {
        return this.iBi;
    }

    public void ph(boolean z) {
        this.iBi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iBk != null) {
            int size = this.iBk.size();
            if (this.iBh) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.iBk, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.iBh && i == getCount() - 1) {
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
        if (this.iBk != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.iBe.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.iBn = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.iBo = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.iBp = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.iBe.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.iBr = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.iBr.setIsRound(false);
                    bVar2.iBr.setAutoChangeStyle(true);
                    bVar2.iAf = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.iBs = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.iBt = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.iBu = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.iBq = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.agz = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.iBv = inflate2.findViewById(R.id.list_line);
                    bVar2.iBw = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.iBv.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.iBw.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.iBg) {
                    bVar.iBo.setText(R.string.members_load_more_person);
                    bVar.iBp.setVisibility(0);
                } else {
                    bVar.iBo.setText(R.string.members_no_more_person);
                    bVar.iBp.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.iBr.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.iBr.startLoad(portrait, 12, false);
                    }
                    bVar.iAf.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.iBs.setVisibility(0);
                            am.setImageResource(bVar.iBs, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.iBs.setVisibility(0);
                            am.setImageResource(bVar.iBs, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.iBs.setVisibility(8);
                            break;
                    }
                    bVar.iBt.setText(c(userData));
                    bVar.iBu.setText(userData.getPosition());
                    this.iBl = userData.getTShowInfo();
                    if (bVar.agz != null) {
                        bVar.agz.a(this.iBl, 2, this.iBe.getResources().getDimensionPixelSize(R.dimen.ds38), this.iBe.getResources().getDimensionPixelSize(R.dimen.ds38), this.iBe.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.iBi) {
                        bVar.iBq.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.iBq.setTag(valueOf);
                        bVar.iBq.setSelected(this.iBj.contains(valueOf));
                        bVar.iBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.iBj.add(l);
                                    } else {
                                        l.this.iBj.remove(l);
                                    }
                                    if (l.this.iBf != null) {
                                        l.this.iBf.xG(l.this.iBj.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.iBq.setVisibility(8);
                    }
                    cf(view);
                }
            }
        }
        return view;
    }

    private void cf(View view) {
        this.iBe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iBe.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cmu = this.iBe.cmu();
        switch (cmu.getOrderType()) {
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
            if (cmu.getOrderType() == 1) {
                return this.iBe.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox agz = null;
        TextView iAf;
        LinearLayout iBn;
        TextView iBo;
        ProgressBar iBp;
        ImageView iBq;
        HeadImageView iBr;
        ImageView iBs;
        TextView iBt;
        TextView iBu;
        View iBv;
        View iBw;

        b() {
        }
    }
}
