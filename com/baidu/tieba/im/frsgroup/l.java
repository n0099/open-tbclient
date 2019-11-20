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
    private final MembersActivity gHi;
    private a gHj;
    private boolean gHk;
    private boolean gHm;
    private final Set<Long> gHn = new HashSet();
    private final List<UserData> gHo = new ArrayList();
    private ArrayList<IconData> gHp = null;
    private boolean gHl = false;

    /* loaded from: classes5.dex */
    public interface a {
        void uh(int i);
    }

    public void a(a aVar) {
        this.gHj = aVar;
    }

    public void dm(List<UserData> list) {
        this.gHo.addAll(list);
    }

    public void dn(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gHo.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bBm() {
        this.gHn.clear();
    }

    public Set<Long> bBn() {
        return this.gHn;
    }

    public void d(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.gHn.contains(l)) {
                this.gHn.remove(l);
            } else {
                this.gHn.add(l);
            }
            notifyDataSetChanged();
            if (this.gHj != null) {
                this.gHj.uh(this.gHn.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gHo.clear();
        }
        this.gHl = false;
        this.gHk = true;
    }

    public l(MembersActivity membersActivity) {
        this.gHi = membersActivity;
    }

    public void lX(boolean z) {
        this.gHk = z;
    }

    public boolean bbl() {
        return this.gHk;
    }

    public void lY(boolean z) {
        this.gHl = z;
    }

    public boolean byq() {
        return this.gHm;
    }

    public void lZ(boolean z) {
        this.gHm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gHo != null) {
            int size = this.gHo.size();
            if (this.gHl) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.gHo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gHl && i == getCount() - 1) {
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
        if (this.gHo != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gHi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gHr = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gHs = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gHt = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gHi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gHv = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gHv.setIsRound(false);
                    bVar2.gHv.setAutoChangeStyle(true);
                    bVar2.gGj = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gHw = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gHx = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gHy = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gHu = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.Hh = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gHz = inflate2.findViewById(R.id.list_line);
                    bVar2.gHA = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gHz.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gHA.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gHk) {
                    bVar.gHs.setText(R.string.members_load_more_person);
                    bVar.gHt.setVisibility(0);
                } else {
                    bVar.gHs.setText(R.string.members_no_more_person);
                    bVar.gHt.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gHv.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.gHv.startLoad(portrait, 12, false);
                    }
                    bVar.gGj.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gHw.setVisibility(0);
                            am.setImageResource(bVar.gHw, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gHw.setVisibility(0);
                            am.setImageResource(bVar.gHw, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gHw.setVisibility(8);
                            break;
                    }
                    bVar.gHx.setText(c(userData));
                    bVar.gHy.setText(userData.getPosition());
                    this.gHp = userData.getTShowInfo();
                    if (bVar.Hh != null) {
                        bVar.Hh.a(this.gHp, 2, this.gHi.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHi.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHi.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gHm) {
                        bVar.gHu.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gHu.setTag(valueOf);
                        bVar.gHu.setSelected(this.gHn.contains(valueOf));
                        bVar.gHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gHn.add(l);
                                    } else {
                                        l.this.gHn.remove(l);
                                    }
                                    if (l.this.gHj != null) {
                                        l.this.gHj.uh(l.this.gHn.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gHu.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.gHi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gHi.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bBg = this.gHi.bBg();
        switch (bBg.getOrderType()) {
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
            if (bBg.getOrderType() == 1) {
                return this.gHi.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox Hh = null;
        TextView gGj;
        View gHA;
        LinearLayout gHr;
        TextView gHs;
        ProgressBar gHt;
        ImageView gHu;
        HeadImageView gHv;
        ImageView gHw;
        TextView gHx;
        TextView gHy;
        View gHz;

        b() {
        }
    }
}
