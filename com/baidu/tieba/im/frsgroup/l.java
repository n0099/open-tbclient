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
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes22.dex */
public class l extends BaseAdapter {
    private final MembersActivity kgT;
    private a kgU;
    private boolean kgV;
    private boolean kgX;
    private final Set<Long> kgY = new HashSet();
    private final List<UserData> kgZ = new ArrayList();
    private ArrayList<IconData> kha = null;
    private boolean kgW = false;

    /* loaded from: classes22.dex */
    public interface a {
        void Du(int i);
    }

    public void a(a aVar) {
        this.kgU = aVar;
    }

    public void el(List<UserData> list) {
        this.kgZ.addAll(list);
    }

    public void em(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.kgZ.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cRS() {
        this.kgY.clear();
    }

    public Set<Long> cRT() {
        return this.kgY;
    }

    public void i(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.kgY.contains(l)) {
                this.kgY.remove(l);
            } else {
                this.kgY.add(l);
            }
            notifyDataSetChanged();
            if (this.kgU != null) {
                this.kgU.Du(this.kgY.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.kgZ.clear();
        }
        this.kgW = false;
        this.kgV = true;
    }

    public l(MembersActivity membersActivity) {
        this.kgT = membersActivity;
    }

    public void rW(boolean z) {
        this.kgV = z;
    }

    public boolean cRU() {
        return this.kgV;
    }

    public void rX(boolean z) {
        this.kgW = z;
    }

    public boolean cOF() {
        return this.kgX;
    }

    public void rY(boolean z) {
        this.kgX = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kgZ != null) {
            int size = this.kgZ.size();
            if (this.kgW) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.kgZ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.kgW && i == getCount() - 1) {
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
        if (this.kgZ != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.kgT.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.khc = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.khd = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.khe = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kgT.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.khg = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.khg.setIsRound(false);
                    bVar2.khg.setAutoChangeStyle(true);
                    bVar2.kfV = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.khh = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.khi = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.khj = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.khf = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ajC = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.khk = inflate2.findViewById(R.id.list_line);
                    bVar2.khl = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.khk.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.khl.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.kgV) {
                    bVar.khd.setText(R.string.members_load_more_person);
                    bVar.khe.setVisibility(0);
                } else {
                    bVar.khd.setText(R.string.members_no_more_person);
                    bVar.khe.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.khg.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!au.isEmpty(portrait)) {
                        bVar.khg.startLoad(portrait, 12, false);
                    }
                    bVar.kfV.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.khh.setVisibility(0);
                            ap.setImageResource(bVar.khh, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.khh.setVisibility(0);
                            ap.setImageResource(bVar.khh, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.khh.setVisibility(8);
                            break;
                    }
                    bVar.khi.setText(c(userData));
                    bVar.khj.setText(userData.getPosition());
                    this.kha = userData.getTShowInfo();
                    if (bVar.ajC != null) {
                        bVar.ajC.a(this.kha, 2, this.kgT.getResources().getDimensionPixelSize(R.dimen.ds38), this.kgT.getResources().getDimensionPixelSize(R.dimen.ds38), this.kgT.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.kgX) {
                        bVar.khf.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.khf.setTag(valueOf);
                        bVar.khf.setSelected(this.kgY.contains(valueOf));
                        bVar.khf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.kgY.add(l);
                                    } else {
                                        l.this.kgY.remove(l);
                                    }
                                    if (l.this.kgU != null) {
                                        l.this.kgU.Du(l.this.kgY.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.khf.setVisibility(8);
                    }
                    cO(view);
                }
            }
        }
        return view;
    }

    private void cO(View view) {
        this.kgT.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kgT.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cRM = this.kgT.cRM();
        switch (cRM.getOrderType()) {
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
            if (cRM.getOrderType() == 1) {
                return this.kgT.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return au.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes22.dex */
    static class b {
        UserIconBox ajC = null;
        TextView kfV;
        LinearLayout khc;
        TextView khd;
        ProgressBar khe;
        ImageView khf;
        HeadImageView khg;
        ImageView khh;
        TextView khi;
        TextView khj;
        View khk;
        View khl;

        b() {
        }
    }
}
