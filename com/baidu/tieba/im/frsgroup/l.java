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
    private final MembersActivity gIj;
    private a gIk;
    private boolean gIl;
    private boolean gIn;
    private final Set<Long> gIo = new HashSet();
    private final List<UserData> gIp = new ArrayList();
    private ArrayList<IconData> gIq = null;
    private boolean gIm = false;

    /* loaded from: classes5.dex */
    public interface a {
        void vy(int i);
    }

    public void a(a aVar) {
        this.gIk = aVar;
    }

    public void cZ(List<UserData> list) {
        this.gIp.addAll(list);
    }

    public void da(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gIp.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bDP() {
        this.gIo.clear();
    }

    public Set<Long> bDQ() {
        return this.gIo;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.ks()) {
            if (this.gIo.contains(l)) {
                this.gIo.remove(l);
            } else {
                this.gIo.add(l);
            }
            notifyDataSetChanged();
            if (this.gIk != null) {
                this.gIk.vy(this.gIo.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gIp.clear();
        }
        this.gIm = false;
        this.gIl = true;
    }

    public l(MembersActivity membersActivity) {
        this.gIj = membersActivity;
    }

    public void mg(boolean z) {
        this.gIl = z;
    }

    public boolean baF() {
        return this.gIl;
    }

    public void mh(boolean z) {
        this.gIm = z;
    }

    public boolean bAU() {
        return this.gIn;
    }

    public void mi(boolean z) {
        this.gIn = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gIp != null) {
            int size = this.gIp.size();
            if (this.gIm) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gIp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gIm && i == getCount() - 1) {
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
        if (this.gIp != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gIj.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gIs = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gIt = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gIu = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gIj.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gIw = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gIw.setIsRound(false);
                    bVar2.gIw.setAutoChangeStyle(true);
                    bVar2.gHk = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gIx = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gIy = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gIz = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gIv = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.XO = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gIA = inflate2.findViewById(R.id.list_line);
                    bVar2.gIB = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gIA.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gIB.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gIl) {
                    bVar.gIt.setText(R.string.members_load_more_person);
                    bVar.gIu.setVisibility(0);
                } else {
                    bVar.gIt.setText(R.string.members_no_more_person);
                    bVar.gIu.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gIw.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.gIw.startLoad(portrait, 12, false);
                    }
                    bVar.gHk.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gIx.setVisibility(0);
                            am.c(bVar.gIx, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gIx.setVisibility(0);
                            am.c(bVar.gIx, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gIx.setVisibility(8);
                            break;
                    }
                    bVar.gIy.setText(d(userData));
                    bVar.gIz.setText(userData.getPosition());
                    this.gIq = userData.getTShowInfo();
                    if (bVar.XO != null) {
                        bVar.XO.a(this.gIq, 2, this.gIj.getResources().getDimensionPixelSize(R.dimen.ds38), this.gIj.getResources().getDimensionPixelSize(R.dimen.ds38), this.gIj.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gIn) {
                        bVar.gIv.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gIv.setTag(valueOf);
                        bVar.gIv.setSelected(this.gIo.contains(valueOf));
                        bVar.gIv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gIo.add(l);
                                    } else {
                                        l.this.gIo.remove(l);
                                    }
                                    if (l.this.gIk != null) {
                                        l.this.gIk.vy(l.this.gIo.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gIv.setVisibility(8);
                    }
                    ca(view);
                }
            }
        }
        return view;
    }

    private void ca(View view) {
        this.gIj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gIj.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bDJ = this.gIj.bDJ();
        switch (bDJ.getOrderType()) {
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
            if (bDJ.getOrderType() == 1) {
                return this.gIj.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox XO = null;
        TextView gHk;
        View gIA;
        View gIB;
        LinearLayout gIs;
        TextView gIt;
        ProgressBar gIu;
        ImageView gIv;
        HeadImageView gIw;
        ImageView gIx;
        TextView gIy;
        TextView gIz;

        b() {
        }
    }
}
