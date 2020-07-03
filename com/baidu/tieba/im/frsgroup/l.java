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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
    private final MembersActivity iSW;
    private a iSX;
    private boolean iSY;
    private boolean iTa;
    private final Set<Long> iTb = new HashSet();
    private final List<UserData> iTc = new ArrayList();
    private ArrayList<IconData> iTd = null;
    private boolean iSZ = false;

    /* loaded from: classes10.dex */
    public interface a {
        void ys(int i);
    }

    public void a(a aVar) {
        this.iSX = aVar;
    }

    public void dv(List<UserData> list) {
        this.iTc.addAll(list);
    }

    public void dw(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.iTc.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cqy() {
        this.iTb.clear();
    }

    public Set<Long> cqz() {
        return this.iTb;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.iTb.contains(l)) {
                this.iTb.remove(l);
            } else {
                this.iTb.add(l);
            }
            notifyDataSetChanged();
            if (this.iSX != null) {
                this.iSX.ys(this.iTb.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.iTc.clear();
        }
        this.iSZ = false;
        this.iSY = true;
    }

    public l(MembersActivity membersActivity) {
        this.iSW = membersActivity;
    }

    public void pp(boolean z) {
        this.iSY = z;
    }

    public boolean cqA() {
        return this.iSY;
    }

    public void pq(boolean z) {
        this.iSZ = z;
    }

    public boolean cnH() {
        return this.iTa;
    }

    public void pr(boolean z) {
        this.iTa = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iTc != null) {
            int size = this.iTc.size();
            if (this.iSZ) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.getItem(this.iTc, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.iSZ && i == getCount() - 1) {
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
        if (this.iTc != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.iSW.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.iTf = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.iTg = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.iTh = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.iSW.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.iTj = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.iTj.setIsRound(false);
                    bVar2.iTj.setAutoChangeStyle(true);
                    bVar2.iRX = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.iTk = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.iTl = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.iTm = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.iTi = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ahD = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.iTn = inflate2.findViewById(R.id.list_line);
                    bVar2.iTo = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.iTn.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.iTo.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.iSY) {
                    bVar.iTg.setText(R.string.members_load_more_person);
                    bVar.iTh.setVisibility(0);
                } else {
                    bVar.iTg.setText(R.string.members_no_more_person);
                    bVar.iTh.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.iTj.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ar.isEmpty(portrait)) {
                        bVar.iTj.startLoad(portrait, 12, false);
                    }
                    bVar.iRX.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.iTk.setVisibility(0);
                            an.setImageResource(bVar.iTk, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.iTk.setVisibility(0);
                            an.setImageResource(bVar.iTk, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.iTk.setVisibility(8);
                            break;
                    }
                    bVar.iTl.setText(c(userData));
                    bVar.iTm.setText(userData.getPosition());
                    this.iTd = userData.getTShowInfo();
                    if (bVar.ahD != null) {
                        bVar.ahD.a(this.iTd, 2, this.iSW.getResources().getDimensionPixelSize(R.dimen.ds38), this.iSW.getResources().getDimensionPixelSize(R.dimen.ds38), this.iSW.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.iTa) {
                        bVar.iTi.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.iTi.setTag(valueOf);
                        bVar.iTi.setSelected(this.iTb.contains(valueOf));
                        bVar.iTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.iTb.add(l);
                                    } else {
                                        l.this.iTb.remove(l);
                                    }
                                    if (l.this.iSX != null) {
                                        l.this.iSX.ys(l.this.iTb.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.iTi.setVisibility(8);
                    }
                    cg(view);
                }
            }
        }
        return view;
    }

    private void cg(View view) {
        this.iSW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iSW.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cqs = this.iSW.cqs();
        switch (cqs.getOrderType()) {
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
            if (cqs.getOrderType() == 1) {
                return this.iSW.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return ar.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox ahD = null;
        TextView iRX;
        LinearLayout iTf;
        TextView iTg;
        ProgressBar iTh;
        ImageView iTi;
        HeadImageView iTj;
        ImageView iTk;
        TextView iTl;
        TextView iTm;
        View iTn;
        View iTo;

        b() {
        }
    }
}
