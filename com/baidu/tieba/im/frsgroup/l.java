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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private final MembersActivity gBh;
    private a gBi;
    private boolean gBj;
    private boolean gBl;
    private final Set<Long> gBm = new HashSet();
    private final List<UserData> gBn = new ArrayList();
    private ArrayList<IconData> gBo = null;
    private boolean gBk = false;

    /* loaded from: classes5.dex */
    public interface a {
        void uV(int i);
    }

    public void a(a aVar) {
        this.gBi = aVar;
    }

    public void cY(List<UserData> list) {
        this.gBn.addAll(list);
    }

    public void cZ(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gBn.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bAU() {
        this.gBm.clear();
    }

    public Set<Long> bAV() {
        return this.gBm;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.kh()) {
            if (this.gBm.contains(l)) {
                this.gBm.remove(l);
            } else {
                this.gBm.add(l);
            }
            notifyDataSetChanged();
            if (this.gBi != null) {
                this.gBi.uV(this.gBm.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gBn.clear();
        }
        this.gBk = false;
        this.gBj = true;
    }

    public l(MembersActivity membersActivity) {
        this.gBh = membersActivity;
    }

    public void lS(boolean z) {
        this.gBj = z;
    }

    public boolean aYE() {
        return this.gBj;
    }

    public void lT(boolean z) {
        this.gBk = z;
    }

    public boolean byc() {
        return this.gBl;
    }

    public void lU(boolean z) {
        this.gBl = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBn != null) {
            int size = this.gBn.size();
            if (this.gBk) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gBn, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gBk && i == getCount() - 1) {
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
        if (this.gBn != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gBh.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gBq = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gBr = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gBs = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gBh.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gBu = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gBu.setIsRound(false);
                    bVar2.gBu.setAutoChangeStyle(true);
                    bVar2.gAi = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gBv = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gBw = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gBx = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gBt = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.Xt = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gBy = inflate2.findViewById(R.id.list_line);
                    bVar2.gBz = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gBy.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gBz.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gBj) {
                    bVar.gBr.setText(R.string.members_load_more_person);
                    bVar.gBs.setVisibility(0);
                } else {
                    bVar.gBr.setText(R.string.members_no_more_person);
                    bVar.gBs.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gBu.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gBu.startLoad(portrait, 12, false);
                    }
                    bVar.gAi.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gBv.setVisibility(0);
                            al.c(bVar.gBv, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gBv.setVisibility(0);
                            al.c(bVar.gBv, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gBv.setVisibility(8);
                            break;
                    }
                    bVar.gBw.setText(d(userData));
                    bVar.gBx.setText(userData.getPosition());
                    this.gBo = userData.getTShowInfo();
                    if (bVar.Xt != null) {
                        bVar.Xt.a(this.gBo, 2, this.gBh.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBh.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBh.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gBl) {
                        bVar.gBt.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gBt.setTag(valueOf);
                        bVar.gBt.setSelected(this.gBm.contains(valueOf));
                        bVar.gBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gBm.add(l);
                                    } else {
                                        l.this.gBm.remove(l);
                                    }
                                    if (l.this.gBi != null) {
                                        l.this.gBi.uV(l.this.gBm.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gBt.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.gBh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gBh.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bAO = this.gBh.bAO();
        switch (bAO.getOrderType()) {
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
            if (bAO.getOrderType() == 1) {
                return this.gBh.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox Xt = null;
        TextView gAi;
        LinearLayout gBq;
        TextView gBr;
        ProgressBar gBs;
        ImageView gBt;
        HeadImageView gBu;
        ImageView gBv;
        TextView gBw;
        TextView gBx;
        View gBy;
        View gBz;

        b() {
        }
    }
}
