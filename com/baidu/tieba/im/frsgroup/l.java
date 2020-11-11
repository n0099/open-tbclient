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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private final MembersActivity kgj;
    private a kgk;
    private boolean kgl;
    private boolean kgn;
    private final Set<Long> kgo = new HashSet();
    private final List<UserData> kgp = new ArrayList();
    private ArrayList<IconData> kgq = null;
    private boolean kgm = false;

    /* loaded from: classes23.dex */
    public interface a {
        void CW(int i);
    }

    public void a(a aVar) {
        this.kgk = aVar;
    }

    public void el(List<UserData> list) {
        this.kgp.addAll(list);
    }

    public void em(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.kgp.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cSm() {
        this.kgo.clear();
    }

    public Set<Long> cSn() {
        return this.kgo;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.kgo.contains(l)) {
                this.kgo.remove(l);
            } else {
                this.kgo.add(l);
            }
            notifyDataSetChanged();
            if (this.kgk != null) {
                this.kgk.CW(this.kgo.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.kgp.clear();
        }
        this.kgm = false;
        this.kgl = true;
    }

    public l(MembersActivity membersActivity) {
        this.kgj = membersActivity;
    }

    public void rT(boolean z) {
        this.kgl = z;
    }

    public boolean cSo() {
        return this.kgl;
    }

    public void rU(boolean z) {
        this.kgm = z;
    }

    public boolean cOZ() {
        return this.kgn;
    }

    public void rV(boolean z) {
        this.kgn = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kgp != null) {
            int size = this.kgp.size();
            if (this.kgm) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.kgp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.kgm && i == getCount() - 1) {
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
        if (this.kgp != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.kgj.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.kgs = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.kgt = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.kgu = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kgj.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.kgw = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.kgw.setIsRound(false);
                    bVar2.kgw.setAutoChangeStyle(true);
                    bVar2.kfl = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.kgx = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.kgy = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.kgz = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.kgv = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ajx = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.kgA = inflate2.findViewById(R.id.list_line);
                    bVar2.kgB = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.kgA.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.kgB.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.kgl) {
                    bVar.kgt.setText(R.string.members_load_more_person);
                    bVar.kgu.setVisibility(0);
                } else {
                    bVar.kgt.setText(R.string.members_no_more_person);
                    bVar.kgu.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.kgw.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.kgw.startLoad(portrait, 12, false);
                    }
                    bVar.kfl.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.kgx.setVisibility(0);
                            ap.setImageResource(bVar.kgx, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.kgx.setVisibility(0);
                            ap.setImageResource(bVar.kgx, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.kgx.setVisibility(8);
                            break;
                    }
                    bVar.kgy.setText(c(userData));
                    bVar.kgz.setText(userData.getPosition());
                    this.kgq = userData.getTShowInfo();
                    if (bVar.ajx != null) {
                        bVar.ajx.a(this.kgq, 2, this.kgj.getResources().getDimensionPixelSize(R.dimen.ds38), this.kgj.getResources().getDimensionPixelSize(R.dimen.ds38), this.kgj.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.kgn) {
                        bVar.kgv.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.kgv.setTag(valueOf);
                        bVar.kgv.setSelected(this.kgo.contains(valueOf));
                        bVar.kgv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.kgo.add(l);
                                    } else {
                                        l.this.kgo.remove(l);
                                    }
                                    if (l.this.kgk != null) {
                                        l.this.kgk.CW(l.this.kgo.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.kgv.setVisibility(8);
                    }
                    cK(view);
                }
            }
        }
        return view;
    }

    private void cK(View view) {
        this.kgj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kgj.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cSg = this.kgj.cSg();
        switch (cSg.getOrderType()) {
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
            if (cSg.getOrderType() == 1) {
                return this.kgj.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes23.dex */
    static class b {
        UserIconBox ajx = null;
        TextView kfl;
        View kgA;
        View kgB;
        LinearLayout kgs;
        TextView kgt;
        ProgressBar kgu;
        ImageView kgv;
        HeadImageView kgw;
        ImageView kgx;
        TextView kgy;
        TextView kgz;

        b() {
        }
    }
}
