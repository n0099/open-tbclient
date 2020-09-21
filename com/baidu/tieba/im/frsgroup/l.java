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
/* loaded from: classes22.dex */
public class l extends BaseAdapter {
    private final MembersActivity jyQ;
    private a jyR;
    private boolean jyS;
    private boolean jyU;
    private final Set<Long> jyV = new HashSet();
    private final List<UserData> jyW = new ArrayList();
    private ArrayList<IconData> jyX = null;
    private boolean jyT = false;

    /* loaded from: classes22.dex */
    public interface a {
        void BK(int i);
    }

    public void a(a aVar) {
        this.jyR = aVar;
    }

    public void dR(List<UserData> list) {
        this.jyW.addAll(list);
    }

    public void dS(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jyW.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cIV() {
        this.jyV.clear();
    }

    public Set<Long> cIW() {
        return this.jyV;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jyV.contains(l)) {
                this.jyV.remove(l);
            } else {
                this.jyV.add(l);
            }
            notifyDataSetChanged();
            if (this.jyR != null) {
                this.jyR.BK(this.jyV.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jyW.clear();
        }
        this.jyT = false;
        this.jyS = true;
    }

    public l(MembersActivity membersActivity) {
        this.jyQ = membersActivity;
    }

    public void qM(boolean z) {
        this.jyS = z;
    }

    public boolean cIX() {
        return this.jyS;
    }

    public void qN(boolean z) {
        this.jyT = z;
    }

    public boolean cFI() {
        return this.jyU;
    }

    public void qO(boolean z) {
        this.jyU = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jyW != null) {
            int size = this.jyW.size();
            if (this.jyT) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.jyW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jyT && i == getCount() - 1) {
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
        if (this.jyW != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jyQ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jyZ = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jza = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jzb = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jyQ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jzd = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jzd.setIsRound(false);
                    bVar2.jzd.setAutoChangeStyle(true);
                    bVar2.jxS = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jze = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jzf = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jzg = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jzc = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.aje = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jzh = inflate2.findViewById(R.id.list_line);
                    bVar2.jzi = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jzh.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jzi.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jyS) {
                    bVar.jza.setText(R.string.members_load_more_person);
                    bVar.jzb.setVisibility(0);
                } else {
                    bVar.jza.setText(R.string.members_no_more_person);
                    bVar.jzb.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jzd.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.jzd.startLoad(portrait, 12, false);
                    }
                    bVar.jxS.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jze.setVisibility(0);
                            ap.setImageResource(bVar.jze, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jze.setVisibility(0);
                            ap.setImageResource(bVar.jze, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jze.setVisibility(8);
                            break;
                    }
                    bVar.jzf.setText(c(userData));
                    bVar.jzg.setText(userData.getPosition());
                    this.jyX = userData.getTShowInfo();
                    if (bVar.aje != null) {
                        bVar.aje.a(this.jyX, 2, this.jyQ.getResources().getDimensionPixelSize(R.dimen.ds38), this.jyQ.getResources().getDimensionPixelSize(R.dimen.ds38), this.jyQ.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jyU) {
                        bVar.jzc.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jzc.setTag(valueOf);
                        bVar.jzc.setSelected(this.jyV.contains(valueOf));
                        bVar.jzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jyV.add(l);
                                    } else {
                                        l.this.jyV.remove(l);
                                    }
                                    if (l.this.jyR != null) {
                                        l.this.jyR.BK(l.this.jyV.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jzc.setVisibility(8);
                    }
                    cx(view);
                }
            }
        }
        return view;
    }

    private void cx(View view) {
        this.jyQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jyQ.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cIP = this.jyQ.cIP();
        switch (cIP.getOrderType()) {
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
            if (cIP.getOrderType() == 1) {
                return this.jyQ.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes22.dex */
    static class b {
        UserIconBox aje = null;
        TextView jxS;
        LinearLayout jyZ;
        TextView jza;
        ProgressBar jzb;
        ImageView jzc;
        HeadImageView jzd;
        ImageView jze;
        TextView jzf;
        TextView jzg;
        View jzh;
        View jzi;

        b() {
        }
    }
}
