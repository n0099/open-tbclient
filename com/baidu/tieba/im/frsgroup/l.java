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
    private final MembersActivity hAQ;
    private a hAR;
    private boolean hAS;
    private boolean hAU;
    private final Set<Long> hAV = new HashSet();
    private final List<UserData> hAW = new ArrayList();
    private ArrayList<IconData> hAX = null;
    private boolean hAT = false;

    /* loaded from: classes10.dex */
    public interface a {
        void wu(int i);
    }

    public void a(a aVar) {
        this.hAR = aVar;
    }

    public void cX(List<UserData> list) {
        this.hAW.addAll(list);
    }

    public void cY(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hAW.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bVk() {
        this.hAV.clear();
    }

    public Set<Long> bVl() {
        return this.hAV;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hAV.contains(l)) {
                this.hAV.remove(l);
            } else {
                this.hAV.add(l);
            }
            notifyDataSetChanged();
            if (this.hAR != null) {
                this.hAR.wu(this.hAV.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hAW.clear();
        }
        this.hAT = false;
        this.hAS = true;
    }

    public l(MembersActivity membersActivity) {
        this.hAQ = membersActivity;
    }

    public void nz(boolean z) {
        this.hAS = z;
    }

    public boolean bVm() {
        return this.hAS;
    }

    public void nA(boolean z) {
        this.hAT = z;
    }

    public boolean bSu() {
        return this.hAU;
    }

    public void nB(boolean z) {
        this.hAU = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hAW != null) {
            int size = this.hAW.size();
            if (this.hAT) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hAW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hAT && i == getCount() - 1) {
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
        if (this.hAW != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hAQ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hAZ = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hBa = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hBb = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hAQ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hBd = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hBd.setIsRound(false);
                    bVar2.hBd.setAutoChangeStyle(true);
                    bVar2.hzR = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hBe = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hBf = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hBg = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hBc = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.No = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hBh = inflate2.findViewById(R.id.list_line);
                    bVar2.hBi = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.hBh.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.hBi.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.hAS) {
                    bVar.hBa.setText(R.string.members_load_more_person);
                    bVar.hBb.setVisibility(0);
                } else {
                    bVar.hBa.setText(R.string.members_no_more_person);
                    bVar.hBb.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hBd.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hBd.startLoad(portrait, 12, false);
                    }
                    bVar.hzR.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hBe.setVisibility(0);
                            am.setImageResource(bVar.hBe, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hBe.setVisibility(0);
                            am.setImageResource(bVar.hBe, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hBe.setVisibility(8);
                            break;
                    }
                    bVar.hBf.setText(c(userData));
                    bVar.hBg.setText(userData.getPosition());
                    this.hAX = userData.getTShowInfo();
                    if (bVar.No != null) {
                        bVar.No.a(this.hAX, 2, this.hAQ.getResources().getDimensionPixelSize(R.dimen.ds38), this.hAQ.getResources().getDimensionPixelSize(R.dimen.ds38), this.hAQ.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hAU) {
                        bVar.hBc.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hBc.setTag(valueOf);
                        bVar.hBc.setSelected(this.hAV.contains(valueOf));
                        bVar.hBc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hAV.add(l);
                                    } else {
                                        l.this.hAV.remove(l);
                                    }
                                    if (l.this.hAR != null) {
                                        l.this.hAR.wu(l.this.hAV.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hBc.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.hAQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hAQ.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bVe = this.hAQ.bVe();
        switch (bVe.getOrderType()) {
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
            if (bVe.getOrderType() == 1) {
                return this.hAQ.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox No = null;
        LinearLayout hAZ;
        TextView hBa;
        ProgressBar hBb;
        ImageView hBc;
        HeadImageView hBd;
        ImageView hBe;
        TextView hBf;
        TextView hBg;
        View hBh;
        View hBi;
        TextView hzR;

        b() {
        }
    }
}
