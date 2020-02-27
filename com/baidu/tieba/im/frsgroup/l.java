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
    private final MembersActivity hAO;
    private a hAP;
    private boolean hAQ;
    private boolean hAS;
    private final Set<Long> hAT = new HashSet();
    private final List<UserData> hAU = new ArrayList();
    private ArrayList<IconData> hAV = null;
    private boolean hAR = false;

    /* loaded from: classes10.dex */
    public interface a {
        void wu(int i);
    }

    public void a(a aVar) {
        this.hAP = aVar;
    }

    public void cX(List<UserData> list) {
        this.hAU.addAll(list);
    }

    public void cY(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hAU.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bVi() {
        this.hAT.clear();
    }

    public Set<Long> bVj() {
        return this.hAT;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hAT.contains(l)) {
                this.hAT.remove(l);
            } else {
                this.hAT.add(l);
            }
            notifyDataSetChanged();
            if (this.hAP != null) {
                this.hAP.wu(this.hAT.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hAU.clear();
        }
        this.hAR = false;
        this.hAQ = true;
    }

    public l(MembersActivity membersActivity) {
        this.hAO = membersActivity;
    }

    public void nz(boolean z) {
        this.hAQ = z;
    }

    public boolean bVk() {
        return this.hAQ;
    }

    public void nA(boolean z) {
        this.hAR = z;
    }

    public boolean bSs() {
        return this.hAS;
    }

    public void nB(boolean z) {
        this.hAS = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hAU != null) {
            int size = this.hAU.size();
            if (this.hAR) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hAU, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hAR && i == getCount() - 1) {
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
        if (this.hAU != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hAO.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hAX = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hAY = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hAZ = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hAO.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hBb = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hBb.setIsRound(false);
                    bVar2.hBb.setAutoChangeStyle(true);
                    bVar2.hzP = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hBc = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hBd = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hBe = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hBa = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.No = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hBf = inflate2.findViewById(R.id.list_line);
                    bVar2.hBg = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.hBf.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.hBg.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.hAQ) {
                    bVar.hAY.setText(R.string.members_load_more_person);
                    bVar.hAZ.setVisibility(0);
                } else {
                    bVar.hAY.setText(R.string.members_no_more_person);
                    bVar.hAZ.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hBb.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hBb.startLoad(portrait, 12, false);
                    }
                    bVar.hzP.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hBc.setVisibility(0);
                            am.setImageResource(bVar.hBc, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hBc.setVisibility(0);
                            am.setImageResource(bVar.hBc, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hBc.setVisibility(8);
                            break;
                    }
                    bVar.hBd.setText(c(userData));
                    bVar.hBe.setText(userData.getPosition());
                    this.hAV = userData.getTShowInfo();
                    if (bVar.No != null) {
                        bVar.No.a(this.hAV, 2, this.hAO.getResources().getDimensionPixelSize(R.dimen.ds38), this.hAO.getResources().getDimensionPixelSize(R.dimen.ds38), this.hAO.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hAS) {
                        bVar.hBa.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hBa.setTag(valueOf);
                        bVar.hBa.setSelected(this.hAT.contains(valueOf));
                        bVar.hBa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hAT.add(l);
                                    } else {
                                        l.this.hAT.remove(l);
                                    }
                                    if (l.this.hAP != null) {
                                        l.this.hAP.wu(l.this.hAT.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hBa.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.hAO.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hAO.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bVc = this.hAO.bVc();
        switch (bVc.getOrderType()) {
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
            if (bVc.getOrderType() == 1) {
                return this.hAO.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox No = null;
        LinearLayout hAX;
        TextView hAY;
        ProgressBar hAZ;
        ImageView hBa;
        HeadImageView hBb;
        ImageView hBc;
        TextView hBd;
        TextView hBe;
        View hBf;
        View hBg;
        TextView hzP;

        b() {
        }
    }
}
