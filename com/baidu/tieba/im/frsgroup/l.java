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
    private final MembersActivity gBf;
    private a gBg;
    private boolean gBh;
    private boolean gBj;
    private final Set<Long> gBk = new HashSet();
    private final List<UserData> gBl = new ArrayList();
    private ArrayList<IconData> gBm = null;
    private boolean gBi = false;

    /* loaded from: classes5.dex */
    public interface a {
        void uV(int i);
    }

    public void a(a aVar) {
        this.gBg = aVar;
    }

    public void cY(List<UserData> list) {
        this.gBl.addAll(list);
    }

    public void cZ(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gBl.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bAT() {
        this.gBk.clear();
    }

    public Set<Long> bAU() {
        return this.gBk;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.kh()) {
            if (this.gBk.contains(l)) {
                this.gBk.remove(l);
            } else {
                this.gBk.add(l);
            }
            notifyDataSetChanged();
            if (this.gBg != null) {
                this.gBg.uV(this.gBk.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gBl.clear();
        }
        this.gBi = false;
        this.gBh = true;
    }

    public l(MembersActivity membersActivity) {
        this.gBf = membersActivity;
    }

    public void lR(boolean z) {
        this.gBh = z;
    }

    public boolean aYE() {
        return this.gBh;
    }

    public void lS(boolean z) {
        this.gBi = z;
    }

    public boolean byb() {
        return this.gBj;
    }

    public void lT(boolean z) {
        this.gBj = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBl != null) {
            int size = this.gBl.size();
            if (this.gBi) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gBl, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gBi && i == getCount() - 1) {
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
        if (this.gBl != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gBf.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gBo = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gBp = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gBq = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gBf.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gBs = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gBs.setIsRound(false);
                    bVar2.gBs.setAutoChangeStyle(true);
                    bVar2.gAg = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gBt = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gBu = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gBv = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gBr = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.Xu = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gBw = inflate2.findViewById(R.id.list_line);
                    bVar2.gBx = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gBw.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gBx.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gBh) {
                    bVar.gBp.setText(R.string.members_load_more_person);
                    bVar.gBq.setVisibility(0);
                } else {
                    bVar.gBp.setText(R.string.members_no_more_person);
                    bVar.gBq.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gBs.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gBs.startLoad(portrait, 12, false);
                    }
                    bVar.gAg.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gBt.setVisibility(0);
                            al.c(bVar.gBt, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gBt.setVisibility(0);
                            al.c(bVar.gBt, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gBt.setVisibility(8);
                            break;
                    }
                    bVar.gBu.setText(d(userData));
                    bVar.gBv.setText(userData.getPosition());
                    this.gBm = userData.getTShowInfo();
                    if (bVar.Xu != null) {
                        bVar.Xu.a(this.gBm, 2, this.gBf.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBf.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBf.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gBj) {
                        bVar.gBr.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gBr.setTag(valueOf);
                        bVar.gBr.setSelected(this.gBk.contains(valueOf));
                        bVar.gBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gBk.add(l);
                                    } else {
                                        l.this.gBk.remove(l);
                                    }
                                    if (l.this.gBg != null) {
                                        l.this.gBg.uV(l.this.gBk.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gBr.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.gBf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gBf.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bAN = this.gBf.bAN();
        switch (bAN.getOrderType()) {
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
            if (bAN.getOrderType() == 1) {
                return this.gBf.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox Xu = null;
        TextView gAg;
        LinearLayout gBo;
        TextView gBp;
        ProgressBar gBq;
        ImageView gBr;
        HeadImageView gBs;
        ImageView gBt;
        TextView gBu;
        TextView gBv;
        View gBw;
        View gBx;

        b() {
        }
    }
}
