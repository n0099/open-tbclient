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
/* loaded from: classes7.dex */
public class l extends BaseAdapter {
    private final MembersActivity hvm;
    private a hvn;
    private boolean hvo;
    private boolean hvq;
    private final Set<Long> hvr = new HashSet();
    private final List<UserData> hvs = new ArrayList();
    private ArrayList<IconData> hvt = null;
    private boolean hvp = false;

    /* loaded from: classes7.dex */
    public interface a {
        void wj(int i);
    }

    public void a(a aVar) {
        this.hvn = aVar;
    }

    public void db(List<UserData> list) {
        this.hvs.addAll(list);
    }

    public void dc(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hvs.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bSy() {
        this.hvr.clear();
    }

    public Set<Long> bSz() {
        return this.hvr;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hvr.contains(l)) {
                this.hvr.remove(l);
            } else {
                this.hvr.add(l);
            }
            notifyDataSetChanged();
            if (this.hvn != null) {
                this.hvn.wj(this.hvr.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hvs.clear();
        }
        this.hvp = false;
        this.hvo = true;
    }

    public l(MembersActivity membersActivity) {
        this.hvm = membersActivity;
    }

    public void nl(boolean z) {
        this.hvo = z;
    }

    public boolean bSA() {
        return this.hvo;
    }

    public void nm(boolean z) {
        this.hvp = z;
    }

    public boolean bPI() {
        return this.hvq;
    }

    public void nn(boolean z) {
        this.hvq = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hvs != null) {
            int size = this.hvs.size();
            if (this.hvp) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hvs, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hvp && i == getCount() - 1) {
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
        if (this.hvs != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hvm.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hvv = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hvw = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hvx = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hvm.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hvz = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hvz.setIsRound(false);
                    bVar2.hvz.setAutoChangeStyle(true);
                    bVar2.hun = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hvA = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hvB = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hvC = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hvy = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.MH = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hvD = inflate2.findViewById(R.id.list_line);
                    bVar2.hvE = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.hvD.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.hvE.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.hvo) {
                    bVar.hvw.setText(R.string.members_load_more_person);
                    bVar.hvx.setVisibility(0);
                } else {
                    bVar.hvw.setText(R.string.members_no_more_person);
                    bVar.hvx.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hvz.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hvz.startLoad(portrait, 12, false);
                    }
                    bVar.hun.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hvA.setVisibility(0);
                            am.setImageResource(bVar.hvA, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hvA.setVisibility(0);
                            am.setImageResource(bVar.hvA, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hvA.setVisibility(8);
                            break;
                    }
                    bVar.hvB.setText(c(userData));
                    bVar.hvC.setText(userData.getPosition());
                    this.hvt = userData.getTShowInfo();
                    if (bVar.MH != null) {
                        bVar.MH.a(this.hvt, 2, this.hvm.getResources().getDimensionPixelSize(R.dimen.ds38), this.hvm.getResources().getDimensionPixelSize(R.dimen.ds38), this.hvm.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hvq) {
                        bVar.hvy.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hvy.setTag(valueOf);
                        bVar.hvy.setSelected(this.hvr.contains(valueOf));
                        bVar.hvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hvr.add(l);
                                    } else {
                                        l.this.hvr.remove(l);
                                    }
                                    if (l.this.hvn != null) {
                                        l.this.hvn.wj(l.this.hvr.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hvy.setVisibility(8);
                    }
                    bS(view);
                }
            }
        }
        return view;
    }

    private void bS(View view) {
        this.hvm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvm.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bSs = this.hvm.bSs();
        switch (bSs.getOrderType()) {
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
            if (bSs.getOrderType() == 1) {
                return this.hvm.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes7.dex */
    static class b {
        UserIconBox MH = null;
        TextView hun;
        ImageView hvA;
        TextView hvB;
        TextView hvC;
        View hvD;
        View hvE;
        LinearLayout hvv;
        TextView hvw;
        ProgressBar hvx;
        ImageView hvy;
        HeadImageView hvz;

        b() {
        }
    }
}
