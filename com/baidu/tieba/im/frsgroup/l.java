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
    private final MembersActivity hCC;
    private a hCD;
    private boolean hCE;
    private boolean hCG;
    private final Set<Long> hCH = new HashSet();
    private final List<UserData> hCI = new ArrayList();
    private ArrayList<IconData> hCJ = null;
    private boolean hCF = false;

    /* loaded from: classes10.dex */
    public interface a {
        void wC(int i);
    }

    public void a(a aVar) {
        this.hCD = aVar;
    }

    public void cX(List<UserData> list) {
        this.hCI.addAll(list);
    }

    public void cY(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hCI.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bVD() {
        this.hCH.clear();
    }

    public Set<Long> bVE() {
        return this.hCH;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hCH.contains(l)) {
                this.hCH.remove(l);
            } else {
                this.hCH.add(l);
            }
            notifyDataSetChanged();
            if (this.hCD != null) {
                this.hCD.wC(this.hCH.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hCI.clear();
        }
        this.hCF = false;
        this.hCE = true;
    }

    public l(MembersActivity membersActivity) {
        this.hCC = membersActivity;
    }

    public void nF(boolean z) {
        this.hCE = z;
    }

    public boolean bVF() {
        return this.hCE;
    }

    public void nG(boolean z) {
        this.hCF = z;
    }

    public boolean bSN() {
        return this.hCG;
    }

    public void nH(boolean z) {
        this.hCG = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hCI != null) {
            int size = this.hCI.size();
            if (this.hCF) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hCI, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hCF && i == getCount() - 1) {
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
        if (this.hCI != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hCC.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hCL = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hCM = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hCN = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hCC.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hCP = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hCP.setIsRound(false);
                    bVar2.hCP.setAutoChangeStyle(true);
                    bVar2.hBD = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hCQ = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hCR = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hCS = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hCO = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.Np = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hCT = inflate2.findViewById(R.id.list_line);
                    bVar2.hCU = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.hCT.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.hCU.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.hCE) {
                    bVar.hCM.setText(R.string.members_load_more_person);
                    bVar.hCN.setVisibility(0);
                } else {
                    bVar.hCM.setText(R.string.members_no_more_person);
                    bVar.hCN.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hCP.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hCP.startLoad(portrait, 12, false);
                    }
                    bVar.hBD.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hCQ.setVisibility(0);
                            am.setImageResource(bVar.hCQ, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hCQ.setVisibility(0);
                            am.setImageResource(bVar.hCQ, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hCQ.setVisibility(8);
                            break;
                    }
                    bVar.hCR.setText(c(userData));
                    bVar.hCS.setText(userData.getPosition());
                    this.hCJ = userData.getTShowInfo();
                    if (bVar.Np != null) {
                        bVar.Np.a(this.hCJ, 2, this.hCC.getResources().getDimensionPixelSize(R.dimen.ds38), this.hCC.getResources().getDimensionPixelSize(R.dimen.ds38), this.hCC.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hCG) {
                        bVar.hCO.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hCO.setTag(valueOf);
                        bVar.hCO.setSelected(this.hCH.contains(valueOf));
                        bVar.hCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hCH.add(l);
                                    } else {
                                        l.this.hCH.remove(l);
                                    }
                                    if (l.this.hCD != null) {
                                        l.this.hCD.wC(l.this.hCH.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hCO.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.hCC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hCC.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bVx = this.hCC.bVx();
        switch (bVx.getOrderType()) {
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
            if (bVx.getOrderType() == 1) {
                return this.hCC.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox Np = null;
        TextView hBD;
        LinearLayout hCL;
        TextView hCM;
        ProgressBar hCN;
        ImageView hCO;
        HeadImageView hCP;
        ImageView hCQ;
        TextView hCR;
        TextView hCS;
        View hCT;
        View hCU;

        b() {
        }
    }
}
