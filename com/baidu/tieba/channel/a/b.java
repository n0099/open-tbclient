package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity ctR;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.ctR = channelFansActivity;
    }

    public void setData(List<i> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: iR */
    public i getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 != null) {
            aVar = (a) view2.getTag();
        } else {
            view2 = LayoutInflater.from(this.ctR.getPageContext().getPageActivity()).inflate(d.i.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.ctS = (HeadImageView) view2.findViewById(d.g.avatar);
            aVar2.ctS.setAutoChangeStyle(true);
            aVar2.ctS.setIsRound(true);
            aVar2.ctS.setClickable(false);
            aVar2.ctT = (TextView) view2.findViewById(d.g.fans_name);
            aVar2.ctU = (TextView) view2.findViewById(d.g.fans_intro);
            view2.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.ctS.setTag(null);
                aVar.ctS.setDefaultResource(d.f.img_default_100);
                aVar.ctS.startLoad(item.getPortrait(), 12, false);
                aVar.ctS.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.ctT.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.ctU.setText(item.getIntro());
            }
        }
        this.ctR.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ctR.getLayoutMode().u(view2);
        return view2;
    }

    /* loaded from: classes3.dex */
    private class a {
        HeadImageView ctS;
        TextView ctT;
        TextView ctU;

        private a() {
        }
    }
}
