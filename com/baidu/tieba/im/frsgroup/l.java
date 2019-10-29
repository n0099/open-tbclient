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
    private final MembersActivity gHZ;
    private a gIa;
    private boolean gIb;
    private boolean gId;
    private final Set<Long> gIe = new HashSet();
    private final List<UserData> gIf = new ArrayList();
    private ArrayList<IconData> gIg = null;
    private boolean gIc = false;

    /* loaded from: classes5.dex */
    public interface a {
        void ui(int i);
    }

    public void a(a aVar) {
        this.gIa = aVar;
    }

    public void dm(List<UserData> list) {
        this.gIf.addAll(list);
    }

    public void dn(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gIf.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bBo() {
        this.gIe.clear();
    }

    public Set<Long> bBp() {
        return this.gIe;
    }

    public void d(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.gIe.contains(l)) {
                this.gIe.remove(l);
            } else {
                this.gIe.add(l);
            }
            notifyDataSetChanged();
            if (this.gIa != null) {
                this.gIa.ui(this.gIe.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gIf.clear();
        }
        this.gIc = false;
        this.gIb = true;
    }

    public l(MembersActivity membersActivity) {
        this.gHZ = membersActivity;
    }

    public void lX(boolean z) {
        this.gIb = z;
    }

    public boolean bbn() {
        return this.gIb;
    }

    public void lY(boolean z) {
        this.gIc = z;
    }

    public boolean bys() {
        return this.gId;
    }

    public void lZ(boolean z) {
        this.gId = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gIf != null) {
            int size = this.gIf.size();
            if (this.gIc) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.gIf, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gIc && i == getCount() - 1) {
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
        if (this.gIf != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gHZ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gIi = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gIj = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gIk = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gHZ.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gIm = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gIm.setIsRound(false);
                    bVar2.gIm.setAutoChangeStyle(true);
                    bVar2.gHa = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gIn = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gIo = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gIp = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gIl = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.HH = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gIq = inflate2.findViewById(R.id.list_line);
                    bVar2.gIr = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gIq.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gIr.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gIb) {
                    bVar.gIj.setText(R.string.members_load_more_person);
                    bVar.gIk.setVisibility(0);
                } else {
                    bVar.gIj.setText(R.string.members_no_more_person);
                    bVar.gIk.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gIm.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.gIm.startLoad(portrait, 12, false);
                    }
                    bVar.gHa.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gIn.setVisibility(0);
                            am.setImageResource(bVar.gIn, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gIn.setVisibility(0);
                            am.setImageResource(bVar.gIn, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gIn.setVisibility(8);
                            break;
                    }
                    bVar.gIo.setText(c(userData));
                    bVar.gIp.setText(userData.getPosition());
                    this.gIg = userData.getTShowInfo();
                    if (bVar.HH != null) {
                        bVar.HH.a(this.gIg, 2, this.gHZ.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHZ.getResources().getDimensionPixelSize(R.dimen.ds38), this.gHZ.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gId) {
                        bVar.gIl.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gIl.setTag(valueOf);
                        bVar.gIl.setSelected(this.gIe.contains(valueOf));
                        bVar.gIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gIe.add(l);
                                    } else {
                                        l.this.gIe.remove(l);
                                    }
                                    if (l.this.gIa != null) {
                                        l.this.gIa.ui(l.this.gIe.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gIl.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.gHZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gHZ.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bBi = this.gHZ.bBi();
        switch (bBi.getOrderType()) {
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
            if (bBi.getOrderType() == 1) {
                return this.gHZ.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox HH = null;
        TextView gHa;
        LinearLayout gIi;
        TextView gIj;
        ProgressBar gIk;
        ImageView gIl;
        HeadImageView gIm;
        ImageView gIn;
        TextView gIo;
        TextView gIp;
        View gIq;
        View gIr;

        b() {
        }
    }
}
