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
    private final MembersActivity hBc;
    private a hBd;
    private boolean hBe;
    private boolean hBg;
    private final Set<Long> hBh = new HashSet();
    private final List<UserData> hBi = new ArrayList();
    private ArrayList<IconData> hBj = null;
    private boolean hBf = false;

    /* loaded from: classes10.dex */
    public interface a {
        void wu(int i);
    }

    public void a(a aVar) {
        this.hBd = aVar;
    }

    public void cX(List<UserData> list) {
        this.hBi.addAll(list);
    }

    public void cY(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.hBi.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bVl() {
        this.hBh.clear();
    }

    public Set<Long> bVm() {
        return this.hBh;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.hBh.contains(l)) {
                this.hBh.remove(l);
            } else {
                this.hBh.add(l);
            }
            notifyDataSetChanged();
            if (this.hBd != null) {
                this.hBd.wu(this.hBh.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.hBi.clear();
        }
        this.hBf = false;
        this.hBe = true;
    }

    public l(MembersActivity membersActivity) {
        this.hBc = membersActivity;
    }

    public void nz(boolean z) {
        this.hBe = z;
    }

    public boolean bVn() {
        return this.hBe;
    }

    public void nA(boolean z) {
        this.hBf = z;
    }

    public boolean bSv() {
        return this.hBg;
    }

    public void nB(boolean z) {
        this.hBg = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hBi != null) {
            int size = this.hBi.size();
            if (this.hBf) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.hBi, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.hBf && i == getCount() - 1) {
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
        if (this.hBi != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.hBc.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.hBl = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.hBm = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.hBn = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.hBc.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.hBp = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.hBp.setIsRound(false);
                    bVar2.hBp.setAutoChangeStyle(true);
                    bVar2.hAd = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.hBq = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.hBr = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.hBs = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.hBo = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.No = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.hBt = inflate2.findViewById(R.id.list_line);
                    bVar2.hBu = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.hBt.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.hBu.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.hBe) {
                    bVar.hBm.setText(R.string.members_load_more_person);
                    bVar.hBn.setVisibility(0);
                } else {
                    bVar.hBm.setText(R.string.members_no_more_person);
                    bVar.hBn.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.hBp.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!aq.isEmpty(portrait)) {
                        bVar.hBp.startLoad(portrait, 12, false);
                    }
                    bVar.hAd.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.hBq.setVisibility(0);
                            am.setImageResource(bVar.hBq, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.hBq.setVisibility(0);
                            am.setImageResource(bVar.hBq, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.hBq.setVisibility(8);
                            break;
                    }
                    bVar.hBr.setText(c(userData));
                    bVar.hBs.setText(userData.getPosition());
                    this.hBj = userData.getTShowInfo();
                    if (bVar.No != null) {
                        bVar.No.a(this.hBj, 2, this.hBc.getResources().getDimensionPixelSize(R.dimen.ds38), this.hBc.getResources().getDimensionPixelSize(R.dimen.ds38), this.hBc.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.hBg) {
                        bVar.hBo.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.hBo.setTag(valueOf);
                        bVar.hBo.setSelected(this.hBh.contains(valueOf));
                        bVar.hBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.hBh.add(l);
                                    } else {
                                        l.this.hBh.remove(l);
                                    }
                                    if (l.this.hBd != null) {
                                        l.this.hBd.wu(l.this.hBh.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.hBo.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.hBc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hBc.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel bVf = this.hBc.bVf();
        switch (bVf.getOrderType()) {
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
            if (bVf.getOrderType() == 1) {
                return this.hBc.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return aq.j(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes10.dex */
    static class b {
        UserIconBox No = null;
        TextView hAd;
        LinearLayout hBl;
        TextView hBm;
        ProgressBar hBn;
        ImageView hBo;
        HeadImageView hBp;
        ImageView hBq;
        TextView hBr;
        TextView hBs;
        View hBt;
        View hBu;

        b() {
        }
    }
}
