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
    private final MembersActivity jbg;
    private a jbh;
    private boolean jbi;
    private boolean jbk;
    private final Set<Long> jbl = new HashSet();
    private final List<UserData> jbm = new ArrayList();
    private ArrayList<IconData> jbn = null;
    private boolean jbj = false;

    /* loaded from: classes17.dex */
    public interface a {
        void yQ(int i);
    }

    public void a(a aVar) {
        this.jbh = aVar;
    }

    public void dC(List<UserData> list) {
        this.jbm.addAll(list);
    }

    public void dD(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jbm.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cux() {
        this.jbl.clear();
    }

    public Set<Long> cuy() {
        return this.jbl;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jbl.contains(l)) {
                this.jbl.remove(l);
            } else {
                this.jbl.add(l);
            }
            notifyDataSetChanged();
            if (this.jbh != null) {
                this.jbh.yQ(this.jbl.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jbm.clear();
        }
        this.jbj = false;
        this.jbi = true;
    }

    public l(MembersActivity membersActivity) {
        this.jbg = membersActivity;
    }

    public void pW(boolean z) {
        this.jbi = z;
    }

    public boolean cuz() {
        return this.jbi;
    }

    public void pX(boolean z) {
        this.jbj = z;
    }

    public boolean cri() {
        return this.jbk;
    }

    public void pY(boolean z) {
        this.jbk = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbm != null) {
            int size = this.jbm.size();
            if (this.jbj) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.getItem(this.jbm, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jbj && i == getCount() - 1) {
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
        if (this.jbm != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jbg.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jbp = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jbq = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jbr = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jbg.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jbt = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jbt.setIsRound(false);
                    bVar2.jbt.setAutoChangeStyle(true);
                    bVar2.jah = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jbu = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jbv = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jbw = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jbs = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ahu = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jbx = inflate2.findViewById(R.id.list_line);
                    bVar2.jby = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jbx.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jby.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jbi) {
                    bVar.jbq.setText(R.string.members_load_more_person);
                    bVar.jbr.setVisibility(0);
                } else {
                    bVar.jbq.setText(R.string.members_no_more_person);
                    bVar.jbr.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jbt.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!as.isEmpty(portrait)) {
                        bVar.jbt.startLoad(portrait, 12, false);
                    }
                    bVar.jah.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jbu.setVisibility(0);
                            ao.setImageResource(bVar.jbu, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jbu.setVisibility(0);
                            ao.setImageResource(bVar.jbu, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jbu.setVisibility(8);
                            break;
                    }
                    bVar.jbv.setText(c(userData));
                    bVar.jbw.setText(userData.getPosition());
                    this.jbn = userData.getTShowInfo();
                    if (bVar.ahu != null) {
                        bVar.ahu.a(this.jbn, 2, this.jbg.getResources().getDimensionPixelSize(R.dimen.ds38), this.jbg.getResources().getDimensionPixelSize(R.dimen.ds38), this.jbg.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jbk) {
                        bVar.jbs.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jbs.setTag(valueOf);
                        bVar.jbs.setSelected(this.jbl.contains(valueOf));
                        bVar.jbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jbl.add(l);
                                    } else {
                                        l.this.jbl.remove(l);
                                    }
                                    if (l.this.jbh != null) {
                                        l.this.jbh.yQ(l.this.jbl.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jbs.setVisibility(8);
                    }
                    cm(view);
                }
            }
        }
        return view;
    }

    private void cm(View view) {
        this.jbg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jbg.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cur = this.jbg.cur();
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
                return this.jbg.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return as.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes17.dex */
    static class b {
        UserIconBox ahu = null;
        TextView jah;
        LinearLayout jbp;
        TextView jbq;
        ProgressBar jbr;
        ImageView jbs;
        HeadImageView jbt;
        ImageView jbu;
        TextView jbv;
        TextView jbw;
        View jbx;
        View jby;

        b() {
        }
    }
}
