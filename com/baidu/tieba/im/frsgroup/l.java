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
    private boolean imB;
    private final MembersActivity imx;
    private a imy;
    private boolean imz;
    private final Set<Long> imC = new HashSet();
    private final List<UserData> imD = new ArrayList();
    private ArrayList<IconData> imE = null;
    private boolean imA = false;

    /* loaded from: classes10.dex */
    public interface a {
        void xa(int i);
    }

    public void a(a aVar) {
        this.imy = aVar;
    }

    public void di(List<UserData> list) {
        this.imD.addAll(list);
    }

    public void dj(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.imD.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cgc() {
        this.imC.clear();
    }

    public Set<Long> cgd() {
        return this.imC;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.imC.contains(l)) {
                this.imC.remove(l);
            } else {
                this.imC.add(l);
            }
            notifyDataSetChanged();
            if (this.imy != null) {
                this.imy.xa(this.imC.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.imD.clear();
        }
        this.imA = false;
        this.imz = true;
    }

    public l(MembersActivity membersActivity) {
        this.imx = membersActivity;
    }

    public void oJ(boolean z) {
        this.imz = z;
    }

    public boolean cge() {
        return this.imz;
    }

    public void oK(boolean z) {
        this.imA = z;
    }

    public boolean cdk() {
        return this.imB;
    }

    public void oL(boolean z) {
        this.imB = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.imD != null) {
            int size = this.imD.size();
            if (this.imA) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.imD, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.imA && i == getCount() - 1) {
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
        if (this.imD != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.imx.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.imG = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.imH = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.imI = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.imx.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.imK = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.imK.setIsRound(false);
                    bVar2.imK.setAutoChangeStyle(true);
                    bVar2.ilx = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.imL = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.imM = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.imN = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.imJ = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.agc = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.imO = inflate2.findViewById(R.id.list_line);
                    bVar2.imP = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.imO.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.imP.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.imz) {
                    bVar.imH.setText(R.string.members_load_more_person);
                    bVar.imI.setVisibility(0);
                } else {
                    bVar.imH.setText(R.string.members_no_more_person);
                    bVar.imI.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.imK.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.imK.startLoad(portrait, 12, false);
                    }
                    bVar.ilx.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.imL.setVisibility(0);
                            am.setImageResource(bVar.imL, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.imL.setVisibility(0);
                            am.setImageResource(bVar.imL, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.imL.setVisibility(8);
                            break;
                    }
                    bVar.imM.setText(c(userData));
                    bVar.imN.setText(userData.getPosition());
                    this.imE = userData.getTShowInfo();
                    if (bVar.agc != null) {
                        bVar.agc.a(this.imE, 2, this.imx.getResources().getDimensionPixelSize(R.dimen.ds38), this.imx.getResources().getDimensionPixelSize(R.dimen.ds38), this.imx.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.imB) {
                        bVar.imJ.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.imJ.setTag(valueOf);
                        bVar.imJ.setSelected(this.imC.contains(valueOf));
                        bVar.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.imC.add(l);
                                    } else {
                                        l.this.imC.remove(l);
                                    }
                                    if (l.this.imy != null) {
                                        l.this.imy.xa(l.this.imC.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.imJ.setVisibility(8);
                    }
                    cf(view);
                }
            }
        }
        return view;
    }

    private void cf(View view) {
        this.imx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.imx.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cfW = this.imx.cfW();
        switch (cfW.getOrderType()) {
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
            if (cfW.getOrderType() == 1) {
                return this.imx.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox agc = null;
        TextView ilx;
        LinearLayout imG;
        TextView imH;
        ProgressBar imI;
        ImageView imJ;
        HeadImageView imK;
        ImageView imL;
        TextView imM;
        TextView imN;
        View imO;
        View imP;

        b() {
        }
    }
}
