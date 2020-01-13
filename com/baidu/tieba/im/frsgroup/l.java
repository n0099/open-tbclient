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
/* loaded from: classes8.dex */
public class l extends BaseAdapter {
    private final MembersActivity hyP;
    private a hyQ;
    private boolean hyR;
    private boolean hyT;
    private final Set<Long> hyU = new HashSet();
    private final List<UserData> hyV = new ArrayList();
    private ArrayList<IconData> hyW = null;
    private boolean hyS = false;

    /* loaded from: classes8.dex */
    public interface a {
        void wo(int i);
    }

    public void a(a aVar) {
        this.hyQ = aVar;
    }

    public void db(List<UserData> list) {
        this.hyV.addAll(list);
    }

    public void dc(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hyV.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bTH() {
        this.hyU.clear();
    }

    public Set<Long> bTI() {
        return this.hyU;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hyU.contains(l)) {
                this.hyU.remove(l);
            } else {
                this.hyU.add(l);
            }
            notifyDataSetChanged();
            if (this.hyQ != null) {
                this.hyQ.wo(this.hyU.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hyV.clear();
        }
        this.hyS = false;
        this.hyR = true;
    }

    public l(MembersActivity membersActivity) {
        this.hyP = membersActivity;
    }

    public void nx(boolean z) {
        this.hyR = z;
    }

    public boolean bTJ() {
        return this.hyR;
    }

    public void ny(boolean z) {
        this.hyS = z;
    }

    public boolean bQR() {
        return this.hyT;
    }

    public void nz(boolean z) {
        this.hyT = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hyV != null) {
            int size = this.hyV.size();
            if (this.hyS) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hyV, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hyS && i == getCount() - 1) {
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
        if (this.hyV != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hyP.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hyY = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hyZ = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hza = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hyP.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hzc = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hzc.setIsRound(false);
                    bVar2.hzc.setAutoChangeStyle(true);
                    bVar2.hxQ = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hzd = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hze = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hzf = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hzb = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.MP = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hzg = inflate2.findViewById(R.id.list_line);
                    bVar2.hzh = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.hzg.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.hzh.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.hyR) {
                    bVar.hyZ.setText(R.string.members_load_more_person);
                    bVar.hza.setVisibility(0);
                } else {
                    bVar.hyZ.setText(R.string.members_no_more_person);
                    bVar.hza.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hzc.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hzc.startLoad(portrait, 12, false);
                    }
                    bVar.hxQ.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hzd.setVisibility(0);
                            am.setImageResource(bVar.hzd, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hzd.setVisibility(0);
                            am.setImageResource(bVar.hzd, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hzd.setVisibility(8);
                            break;
                    }
                    bVar.hze.setText(c(userData));
                    bVar.hzf.setText(userData.getPosition());
                    this.hyW = userData.getTShowInfo();
                    if (bVar.MP != null) {
                        bVar.MP.a(this.hyW, 2, this.hyP.getResources().getDimensionPixelSize(R.dimen.ds38), this.hyP.getResources().getDimensionPixelSize(R.dimen.ds38), this.hyP.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hyT) {
                        bVar.hzb.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hzb.setTag(valueOf);
                        bVar.hzb.setSelected(this.hyU.contains(valueOf));
                        bVar.hzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hyU.add(l);
                                    } else {
                                        l.this.hyU.remove(l);
                                    }
                                    if (l.this.hyQ != null) {
                                        l.this.hyQ.wo(l.this.hyU.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hzb.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.hyP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hyP.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bTB = this.hyP.bTB();
        switch (bTB.getOrderType()) {
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
            if (bTB.getOrderType() == 1) {
                return this.hyP.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes8.dex */
    static class b {
        UserIconBox MP = null;
        TextView hxQ;
        LinearLayout hyY;
        TextView hyZ;
        ProgressBar hza;
        ImageView hzb;
        HeadImageView hzc;
        ImageView hzd;
        TextView hze;
        TextView hzf;
        View hzg;
        View hzh;

        b() {
        }
    }
}
