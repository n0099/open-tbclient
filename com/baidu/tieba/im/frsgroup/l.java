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
    private final MembersActivity gHr;
    private a gHs;
    private boolean gHt;
    private boolean gHv;
    private final Set<Long> gHw = new HashSet();
    private final List<UserData> gHx = new ArrayList();
    private ArrayList<IconData> gHy = null;
    private boolean gHu = false;

    /* loaded from: classes5.dex */
    public interface a {
        void vw(int i);
    }

    public void a(a aVar) {
        this.gHs = aVar;
    }

    public void da(List<UserData> list) {
        this.gHx.addAll(list);
    }

    public void db(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gHx.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bDB() {
        this.gHw.clear();
    }

    public Set<Long> bDC() {
        return this.gHw;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.ks()) {
            if (this.gHw.contains(l)) {
                this.gHw.remove(l);
            } else {
                this.gHw.add(l);
            }
            notifyDataSetChanged();
            if (this.gHs != null) {
                this.gHs.vw(this.gHw.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gHx.clear();
        }
        this.gHu = false;
        this.gHt = true;
    }

    public l(MembersActivity membersActivity) {
        this.gHr = membersActivity;
    }

    public void mg(boolean z) {
        this.gHt = z;
    }

    public boolean baD() {
        return this.gHt;
    }

    public void mh(boolean z) {
        this.gHu = z;
    }

    public boolean bAG() {
        return this.gHv;
    }

    public void mi(boolean z) {
        this.gHv = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gHx != null) {
            int size = this.gHx.size();
            if (this.gHu) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gHx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gHu && i == getCount() - 1) {
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
        if (this.gHx != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gHr.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gHA = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gHB = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gHC = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gHr.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gHE = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gHE.setIsRound(false);
                    bVar2.gHE.setAutoChangeStyle(true);
                    bVar2.gGs = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gHF = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gHG = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gHH = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gHD = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.XO = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gHI = inflate2.findViewById(R.id.list_line);
                    bVar2.gHJ = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gHI.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gHJ.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gHt) {
                    bVar.gHB.setText(R.string.members_load_more_person);
                    bVar.gHC.setVisibility(0);
                } else {
                    bVar.gHB.setText(R.string.members_no_more_person);
                    bVar.gHC.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gHE.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.gHE.startLoad(portrait, 12, false);
                    }
                    bVar.gGs.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gHF.setVisibility(0);
                            am.c(bVar.gHF, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gHF.setVisibility(0);
                            am.c(bVar.gHF, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gHF.setVisibility(8);
                            break;
                    }
                    bVar.gHG.setText(d(userData));
                    bVar.gHH.setText(userData.getPosition());
                    this.gHy = userData.getTShowInfo();
                    if (bVar.XO != null) {
                        bVar.XO.a(this.gHy, 2, this.gHr.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHr.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHr.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gHv) {
                        bVar.gHD.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gHD.setTag(valueOf);
                        bVar.gHD.setSelected(this.gHw.contains(valueOf));
                        bVar.gHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gHw.add(l);
                                    } else {
                                        l.this.gHw.remove(l);
                                    }
                                    if (l.this.gHs != null) {
                                        l.this.gHs.vw(l.this.gHw.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gHD.setVisibility(8);
                    }
                    bZ(view);
                }
            }
        }
        return view;
    }

    private void bZ(View view) {
        this.gHr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gHr.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bDv = this.gHr.bDv();
        switch (bDv.getOrderType()) {
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
            if (bDv.getOrderType() == 1) {
                return this.gHr.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox XO = null;
        TextView gGs;
        LinearLayout gHA;
        TextView gHB;
        ProgressBar gHC;
        ImageView gHD;
        HeadImageView gHE;
        ImageView gHF;
        TextView gHG;
        TextView gHH;
        View gHI;
        View gHJ;

        b() {
        }
    }
}
