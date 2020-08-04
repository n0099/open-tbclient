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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes17.dex */
public class l extends BaseAdapter {
    private final MembersActivity jbi;
    private a jbj;
    private boolean jbk;
    private boolean jbm;
    private final Set<Long> jbn = new HashSet();
    private final List<UserData> jbo = new ArrayList();
    private ArrayList<IconData> jbp = null;
    private boolean jbl = false;

    /* loaded from: classes17.dex */
    public interface a {
        void yQ(int i);
    }

    public void a(a aVar) {
        this.jbj = aVar;
    }

    public void dC(List<UserData> list) {
        this.jbo.addAll(list);
    }

    public void dD(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jbo.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cux() {
        this.jbn.clear();
    }

    public Set<Long> cuy() {
        return this.jbn;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jbn.contains(l)) {
                this.jbn.remove(l);
            } else {
                this.jbn.add(l);
            }
            notifyDataSetChanged();
            if (this.jbj != null) {
                this.jbj.yQ(this.jbn.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jbo.clear();
        }
        this.jbl = false;
        this.jbk = true;
    }

    public l(MembersActivity membersActivity) {
        this.jbi = membersActivity;
    }

    public void pW(boolean z) {
        this.jbk = z;
    }

    public boolean cuz() {
        return this.jbk;
    }

    public void pX(boolean z) {
        this.jbl = z;
    }

    public boolean cri() {
        return this.jbm;
    }

    public void pY(boolean z) {
        this.jbm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbo != null) {
            int size = this.jbo.size();
            if (this.jbl) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.getItem(this.jbo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jbl && i == getCount() - 1) {
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
        if (this.jbo != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jbi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jbr = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jbs = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jbt = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jbi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jbv = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jbv.setIsRound(false);
                    bVar2.jbv.setAutoChangeStyle(true);
                    bVar2.jaj = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jbw = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jbx = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jby = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jbu = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ahu = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jbz = inflate2.findViewById(R.id.list_line);
                    bVar2.jbA = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jbz.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jbA.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jbk) {
                    bVar.jbs.setText(R.string.members_load_more_person);
                    bVar.jbt.setVisibility(0);
                } else {
                    bVar.jbs.setText(R.string.members_no_more_person);
                    bVar.jbt.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jbv.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!as.isEmpty(portrait)) {
                        bVar.jbv.startLoad(portrait, 12, false);
                    }
                    bVar.jaj.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jbw.setVisibility(0);
                            ao.setImageResource(bVar.jbw, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jbw.setVisibility(0);
                            ao.setImageResource(bVar.jbw, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jbw.setVisibility(8);
                            break;
                    }
                    bVar.jbx.setText(c(userData));
                    bVar.jby.setText(userData.getPosition());
                    this.jbp = userData.getTShowInfo();
                    if (bVar.ahu != null) {
                        bVar.ahu.a(this.jbp, 2, this.jbi.getResources().getDimensionPixelSize(R.dimen.ds38), this.jbi.getResources().getDimensionPixelSize(R.dimen.ds38), this.jbi.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jbm) {
                        bVar.jbu.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jbu.setTag(valueOf);
                        bVar.jbu.setSelected(this.jbn.contains(valueOf));
                        bVar.jbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jbn.add(l);
                                    } else {
                                        l.this.jbn.remove(l);
                                    }
                                    if (l.this.jbj != null) {
                                        l.this.jbj.yQ(l.this.jbn.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jbu.setVisibility(8);
                    }
                    cm(view);
                }
            }
        }
        return view;
    }

    private void cm(View view) {
        this.jbi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jbi.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cur = this.jbi.cur();
        switch (cur.getOrderType()) {
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
            if (cur.getOrderType() == 1) {
                return this.jbi.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return as.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes17.dex */
    static class b {
        UserIconBox ahu = null;
        TextView jaj;
        View jbA;
        LinearLayout jbr;
        TextView jbs;
        ProgressBar jbt;
        ImageView jbu;
        HeadImageView jbv;
        ImageView jbw;
        TextView jbx;
        TextView jby;
        View jbz;

        b() {
        }
    }
}
