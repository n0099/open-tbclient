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
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private boolean jhv;
    private final MembersActivity kut;
    private a kuu;
    private boolean kuv;
    private final Set<Long> kux = new HashSet();
    private final List<UserData> kuy = new ArrayList();
    private ArrayList<IconData> kuz = null;
    private boolean kuw = false;

    /* loaded from: classes23.dex */
    public interface a {
        void Ej(int i);
    }

    public void a(a aVar) {
        this.kuu = aVar;
    }

    public void ew(List<UserData> list) {
        this.kuy.addAll(list);
    }

    public void ex(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.kuy.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cXf() {
        this.kux.clear();
    }

    public Set<Long> cXg() {
        return this.kux;
    }

    public void i(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.kux.contains(l)) {
                this.kux.remove(l);
            } else {
                this.kux.add(l);
            }
            notifyDataSetChanged();
            if (this.kuu != null) {
                this.kuu.Ej(this.kux.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.kuy.clear();
        }
        this.kuw = false;
        this.kuv = true;
    }

    public l(MembersActivity membersActivity) {
        this.kut = membersActivity;
    }

    public void sy(boolean z) {
        this.kuv = z;
    }

    public boolean cXh() {
        return this.kuv;
    }

    public void sz(boolean z) {
        this.kuw = z;
    }

    public boolean cTU() {
        return this.jhv;
    }

    public void sA(boolean z) {
        this.jhv = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kuy != null) {
            int size = this.kuy.size();
            if (this.kuw) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.kuy, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.kuw && i == getCount() - 1) {
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
        if (this.kuy != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.kut.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.kuB = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.kuC = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.kuD = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kut.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.kuF = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.kuF.setIsRound(false);
                    bVar2.kuF.setAutoChangeStyle(true);
                    bVar2.ktv = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.kuG = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.kuH = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.kuI = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.kuE = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.akB = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.kuJ = inflate2.findViewById(R.id.list_line);
                    bVar2.kuK = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.kuJ.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.kuK.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.kuv) {
                    bVar.kuC.setText(R.string.members_load_more_person);
                    bVar.kuD.setVisibility(0);
                } else {
                    bVar.kuC.setText(R.string.members_no_more_person);
                    bVar.kuD.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.kuF.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!au.isEmpty(portrait)) {
                        bVar.kuF.startLoad(portrait, 12, false);
                    }
                    bVar.ktv.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.kuG.setVisibility(0);
                            ap.setImageResource(bVar.kuG, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.kuG.setVisibility(0);
                            ap.setImageResource(bVar.kuG, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.kuG.setVisibility(8);
                            break;
                    }
                    bVar.kuH.setText(c(userData));
                    bVar.kuI.setText(userData.getPosition());
                    this.kuz = userData.getTShowInfo();
                    if (bVar.akB != null) {
                        bVar.akB.a(this.kuz, 2, this.kut.getResources().getDimensionPixelSize(R.dimen.ds38), this.kut.getResources().getDimensionPixelSize(R.dimen.ds38), this.kut.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jhv) {
                        bVar.kuE.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.kuE.setTag(valueOf);
                        bVar.kuE.setSelected(this.kux.contains(valueOf));
                        bVar.kuE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.kux.add(l);
                                    } else {
                                        l.this.kux.remove(l);
                                    }
                                    if (l.this.kuu != null) {
                                        l.this.kuu.Ej(l.this.kux.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.kuE.setVisibility(8);
                    }
                    cV(view);
                }
            }
        }
        return view;
    }

    private void cV(View view) {
        this.kut.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kut.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cWZ = this.kut.cWZ();
        switch (cWZ.getOrderType()) {
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
            if (cWZ.getOrderType() == 1) {
                return this.kut.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return au.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes23.dex */
    static class b {
        UserIconBox akB = null;
        TextView ktv;
        LinearLayout kuB;
        TextView kuC;
        ProgressBar kuD;
        ImageView kuE;
        HeadImageView kuF;
        ImageView kuG;
        TextView kuH;
        TextView kuI;
        View kuJ;
        View kuK;

        b() {
        }
    }
}
