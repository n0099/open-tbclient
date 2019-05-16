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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private final MembersActivity gBe;
    private a gBf;
    private boolean gBg;
    private boolean gBi;
    private final Set<Long> gBj = new HashSet();
    private final List<UserData> gBk = new ArrayList();
    private ArrayList<IconData> gBl = null;
    private boolean gBh = false;

    /* loaded from: classes5.dex */
    public interface a {
        void uV(int i);
    }

    public void a(a aVar) {
        this.gBf = aVar;
    }

    public void cY(List<UserData> list) {
        this.gBk.addAll(list);
    }

    public void cZ(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gBk.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bAQ() {
        this.gBj.clear();
    }

    public Set<Long> bAR() {
        return this.gBj;
    }

    public void e(Long l) {
        if (com.baidu.adp.lib.util.l.kh()) {
            if (this.gBj.contains(l)) {
                this.gBj.remove(l);
            } else {
                this.gBj.add(l);
            }
            notifyDataSetChanged();
            if (this.gBf != null) {
                this.gBf.uV(this.gBj.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gBk.clear();
        }
        this.gBh = false;
        this.gBg = true;
    }

    public l(MembersActivity membersActivity) {
        this.gBe = membersActivity;
    }

    public void lR(boolean z) {
        this.gBg = z;
    }

    public boolean aYB() {
        return this.gBg;
    }

    public void lS(boolean z) {
        this.gBh = z;
    }

    public boolean bxY() {
        return this.gBi;
    }

    public void lT(boolean z) {
        this.gBi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBk != null) {
            int size = this.gBk.size();
            if (this.gBh) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gBk, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gBh && i == getCount() - 1) {
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
        if (this.gBk != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gBe.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.gBn = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.gBo = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.gBp = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gBe.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.gBr = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.gBr.setIsRound(false);
                    bVar2.gBr.setAutoChangeStyle(true);
                    bVar2.gAf = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.gBs = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.gBt = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.gBu = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.gBq = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.Xu = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.gBv = inflate2.findViewById(R.id.list_line);
                    bVar2.gBw = inflate2.findViewById(R.id.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gBv.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gBw.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gBg) {
                    bVar.gBo.setText(R.string.members_load_more_person);
                    bVar.gBp.setVisibility(0);
                } else {
                    bVar.gBo.setText(R.string.members_no_more_person);
                    bVar.gBp.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gBr.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gBr.startLoad(portrait, 12, false);
                    }
                    bVar.gAf.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gBs.setVisibility(0);
                            al.c(bVar.gBs, (int) R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gBs.setVisibility(0);
                            al.c(bVar.gBs, (int) R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gBs.setVisibility(8);
                            break;
                    }
                    bVar.gBt.setText(d(userData));
                    bVar.gBu.setText(userData.getPosition());
                    this.gBl = userData.getTShowInfo();
                    if (bVar.Xu != null) {
                        bVar.Xu.a(this.gBl, 2, this.gBe.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBe.getResources().getDimensionPixelSize(R.dimen.ds38), this.gBe.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.gBi) {
                        bVar.gBq.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gBq.setTag(valueOf);
                        bVar.gBq.setSelected(this.gBj.contains(valueOf));
                        bVar.gBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gBj.add(l);
                                    } else {
                                        l.this.gBj.remove(l);
                                    }
                                    if (l.this.gBf != null) {
                                        l.this.gBf.uV(l.this.gBj.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gBq.setVisibility(8);
                    }
                    bX(view);
                }
            }
        }
        return view;
    }

    private void bX(View view) {
        this.gBe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gBe.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bAK = this.gBe.bAK();
        switch (bAK.getOrderType()) {
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
            if (bAK.getOrderType() == 1) {
                return this.gBe.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox Xu = null;
        TextView gAf;
        LinearLayout gBn;
        TextView gBo;
        ProgressBar gBp;
        ImageView gBq;
        HeadImageView gBr;
        ImageView gBs;
        TextView gBt;
        TextView gBu;
        View gBv;
        View gBw;

        b() {
        }
    }
}
