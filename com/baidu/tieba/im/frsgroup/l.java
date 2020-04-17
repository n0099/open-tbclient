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
    private final MembersActivity imr;
    private a ims;
    private boolean imt;
    private boolean imv;
    private final Set<Long> imw = new HashSet();
    private final List<UserData> imx = new ArrayList();
    private ArrayList<IconData> imy = null;
    private boolean imu = false;

    /* loaded from: classes10.dex */
    public interface a {
        void xa(int i);
    }

    public void a(a aVar) {
        this.ims = aVar;
    }

    public void di(List<UserData> list) {
        this.imx.addAll(list);
    }

    public void dj(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.imx.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cge() {
        this.imw.clear();
    }

    public Set<Long> cgf() {
        return this.imw;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.imw.contains(l)) {
                this.imw.remove(l);
            } else {
                this.imw.add(l);
            }
            notifyDataSetChanged();
            if (this.ims != null) {
                this.ims.xa(this.imw.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.imx.clear();
        }
        this.imu = false;
        this.imt = true;
    }

    public l(MembersActivity membersActivity) {
        this.imr = membersActivity;
    }

    public void oJ(boolean z) {
        this.imt = z;
    }

    public boolean cgg() {
        return this.imt;
    }

    public void oK(boolean z) {
        this.imu = z;
    }

    public boolean cdm() {
        return this.imv;
    }

    public void oL(boolean z) {
        this.imv = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.imx != null) {
            int size = this.imx.size();
            if (this.imu) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.imx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.imu && i == getCount() - 1) {
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
        if (this.imx != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.imr.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.imA = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.imB = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.imC = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.imr.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.imE = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.imE.setIsRound(false);
                    bVar2.imE.setAutoChangeStyle(true);
                    bVar2.ilr = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.imF = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.imG = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.imH = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.imD = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.afZ = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.imI = inflate2.findViewById(R.id.list_line);
                    bVar2.imJ = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.imI.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.imJ.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.imt) {
                    bVar.imB.setText(R.string.members_load_more_person);
                    bVar.imC.setVisibility(0);
                } else {
                    bVar.imB.setText(R.string.members_no_more_person);
                    bVar.imC.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.imE.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.imE.startLoad(portrait, 12, false);
                    }
                    bVar.ilr.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.imF.setVisibility(0);
                            am.setImageResource(bVar.imF, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.imF.setVisibility(0);
                            am.setImageResource(bVar.imF, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.imF.setVisibility(8);
                            break;
                    }
                    bVar.imG.setText(c(userData));
                    bVar.imH.setText(userData.getPosition());
                    this.imy = userData.getTShowInfo();
                    if (bVar.afZ != null) {
                        bVar.afZ.a(this.imy, 2, this.imr.getResources().getDimensionPixelSize(R.dimen.ds38), this.imr.getResources().getDimensionPixelSize(R.dimen.ds38), this.imr.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.imv) {
                        bVar.imD.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.imD.setTag(valueOf);
                        bVar.imD.setSelected(this.imw.contains(valueOf));
                        bVar.imD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.imw.add(l);
                                    } else {
                                        l.this.imw.remove(l);
                                    }
                                    if (l.this.ims != null) {
                                        l.this.ims.xa(l.this.imw.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.imD.setVisibility(8);
                    }
                    cf(view);
                }
            }
        }
        return view;
    }

    private void cf(View view) {
        this.imr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.imr.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cfY = this.imr.cfY();
        switch (cfY.getOrderType()) {
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
            if (cfY.getOrderType() == 1) {
                return this.imr.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox afZ = null;
        TextView ilr;
        LinearLayout imA;
        TextView imB;
        ProgressBar imC;
        ImageView imD;
        HeadImageView imE;
        ImageView imF;
        TextView imG;
        TextView imH;
        View imI;
        View imJ;

        b() {
        }
    }
}
