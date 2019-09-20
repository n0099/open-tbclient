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
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private final MembersActivity gKb;
    private a gKc;
    private boolean gKd;
    private boolean gKf;
    private final Set<Long> gKg = new HashSet();
    private final List<UserData> gKh = new ArrayList();
    private ArrayList<IconData> gKi = null;
    private boolean gKe = false;

    /* loaded from: classes5.dex */
    public interface a {
        void vC(int i);
    }

    public void a(a aVar) {
        this.gKc = aVar;
    }

    public void cZ(List<UserData> list) {
        this.gKh.addAll(list);
    }

    public void da(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gKh.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bED() {
        this.gKg.clear();
    }

    public Set<Long> bEE() {
        return this.gKg;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.ks()) {
            if (this.gKg.contains(l)) {
                this.gKg.remove(l);
            } else {
                this.gKg.add(l);
            }
            notifyDataSetChanged();
            if (this.gKc != null) {
                this.gKc.vC(this.gKg.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gKh.clear();
        }
        this.gKe = false;
        this.gKd = true;
    }

    public l(MembersActivity membersActivity) {
        this.gKb = membersActivity;
    }

    public void mj(boolean z) {
        this.gKd = z;
    }

    public boolean bbj() {
        return this.gKd;
    }

    public void mk(boolean z) {
        this.gKe = z;
    }

    public boolean bBI() {
        return this.gKf;
    }

    public void ml(boolean z) {
        this.gKf = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKh != null) {
            int size = this.gKh.size();
            if (this.gKe) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gKh, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gKe && i == getCount() - 1) {
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
        if (this.gKh != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gKb.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gKk = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gKl = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gKm = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gKb.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gKo = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gKo.setIsRound(false);
                    bVar2.gKo.setAutoChangeStyle(true);
                    bVar2.gJc = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gKp = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gKq = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gKr = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gKn = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.XN = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gKs = inflate2.findViewById(R.id.list_line);
                    bVar2.gKt = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gKs.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gKt.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gKd) {
                    bVar.gKl.setText(R.string.members_load_more_person);
                    bVar.gKm.setVisibility(0);
                } else {
                    bVar.gKl.setText(R.string.members_no_more_person);
                    bVar.gKm.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gKo.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.gKo.startLoad(portrait, 12, false);
                    }
                    bVar.gJc.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gKp.setVisibility(0);
                            am.c(bVar.gKp, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gKp.setVisibility(0);
                            am.c(bVar.gKp, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gKp.setVisibility(8);
                            break;
                    }
                    bVar.gKq.setText(d(userData));
                    bVar.gKr.setText(userData.getPosition());
                    this.gKi = userData.getTShowInfo();
                    if (bVar.XN != null) {
                        bVar.XN.a(this.gKi, 2, this.gKb.getResources().getDimensionPixelSize(R.dimen.ds38), this.gKb.getResources().getDimensionPixelSize(R.dimen.ds38), this.gKb.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gKf) {
                        bVar.gKn.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gKn.setTag(valueOf);
                        bVar.gKn.setSelected(this.gKg.contains(valueOf));
                        bVar.gKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gKg.add(l);
                                    } else {
                                        l.this.gKg.remove(l);
                                    }
                                    if (l.this.gKc != null) {
                                        l.this.gKc.vC(l.this.gKg.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gKn.setVisibility(8);
                    }
                    ca(view);
                }
            }
        }
        return view;
    }

    private void ca(View view) {
        this.gKb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gKb.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bEx = this.gKb.bEx();
        switch (bEx.getOrderType()) {
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
            if (bEx.getOrderType() == 1) {
                return this.gKb.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox XN = null;
        TextView gJc;
        LinearLayout gKk;
        TextView gKl;
        ProgressBar gKm;
        ImageView gKn;
        HeadImageView gKo;
        ImageView gKp;
        TextView gKq;
        TextView gKr;
        View gKs;
        View gKt;

        b() {
        }
    }
}
