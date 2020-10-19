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
    private final MembersActivity jNN;
    private a jNO;
    private boolean jNP;
    private boolean jNR;
    private final Set<Long> jNS = new HashSet();
    private final List<UserData> jNT = new ArrayList();
    private ArrayList<IconData> jNU = null;
    private boolean jNQ = false;

    /* loaded from: classes23.dex */
    public interface a {
        void Cq(int i);
    }

    public void a(a aVar) {
        this.jNO = aVar;
    }

    public void dU(List<UserData> list) {
        this.jNT.addAll(list);
    }

    public void dV(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jNT.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cME() {
        this.jNS.clear();
    }

    public Set<Long> cMF() {
        return this.jNS;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jNS.contains(l)) {
                this.jNS.remove(l);
            } else {
                this.jNS.add(l);
            }
            notifyDataSetChanged();
            if (this.jNO != null) {
                this.jNO.Cq(this.jNS.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jNT.clear();
        }
        this.jNQ = false;
        this.jNP = true;
    }

    public l(MembersActivity membersActivity) {
        this.jNN = membersActivity;
    }

    public void rs(boolean z) {
        this.jNP = z;
    }

    public boolean cMG() {
        return this.jNP;
    }

    public void rt(boolean z) {
        this.jNQ = z;
    }

    public boolean cJr() {
        return this.jNR;
    }

    public void ru(boolean z) {
        this.jNR = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jNT != null) {
            int size = this.jNT.size();
            if (this.jNQ) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.jNT, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jNQ && i == getCount() - 1) {
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
        if (this.jNT != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jNN.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jNW = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jNX = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jNY = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jNN.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jOa = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jOa.setIsRound(false);
                    bVar2.jOa.setAutoChangeStyle(true);
                    bVar2.jMP = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jOb = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jOc = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jOd = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jNZ = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ajw = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jOe = inflate2.findViewById(R.id.list_line);
                    bVar2.jOf = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jOe.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jOf.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jNP) {
                    bVar.jNX.setText(R.string.members_load_more_person);
                    bVar.jNY.setVisibility(0);
                } else {
                    bVar.jNX.setText(R.string.members_no_more_person);
                    bVar.jNY.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jOa.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.jOa.startLoad(portrait, 12, false);
                    }
                    bVar.jMP.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jOb.setVisibility(0);
                            ap.setImageResource(bVar.jOb, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jOb.setVisibility(0);
                            ap.setImageResource(bVar.jOb, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jOb.setVisibility(8);
                            break;
                    }
                    bVar.jOc.setText(c(userData));
                    bVar.jOd.setText(userData.getPosition());
                    this.jNU = userData.getTShowInfo();
                    if (bVar.ajw != null) {
                        bVar.ajw.a(this.jNU, 2, this.jNN.getResources().getDimensionPixelSize(R.dimen.ds38), this.jNN.getResources().getDimensionPixelSize(R.dimen.ds38), this.jNN.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jNR) {
                        bVar.jNZ.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jNZ.setTag(valueOf);
                        bVar.jNZ.setSelected(this.jNS.contains(valueOf));
                        bVar.jNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jNS.add(l);
                                    } else {
                                        l.this.jNS.remove(l);
                                    }
                                    if (l.this.jNO != null) {
                                        l.this.jNO.Cq(l.this.jNS.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jNZ.setVisibility(8);
                    }
                    cB(view);
                }
            }
        }
        return view;
    }

    private void cB(View view) {
        this.jNN.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jNN.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cMy = this.jNN.cMy();
        switch (cMy.getOrderType()) {
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
            if (cMy.getOrderType() == 1) {
                return this.jNN.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes23.dex */
    static class b {
        UserIconBox ajw = null;
        TextView jMP;
        LinearLayout jNW;
        TextView jNX;
        ProgressBar jNY;
        ImageView jNZ;
        HeadImageView jOa;
        ImageView jOb;
        TextView jOc;
        TextView jOd;
        View jOe;
        View jOf;

        b() {
        }
    }
}
