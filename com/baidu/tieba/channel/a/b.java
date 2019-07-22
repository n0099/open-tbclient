package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity eHR;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.eHR = channelFansActivity;
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
    /* renamed from: pM */
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eHR.getPageContext().getPageActivity()).inflate(R.layout.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eHS = (HeadImageView) view.findViewById(R.id.avatar);
            aVar2.eHS.setAutoChangeStyle(true);
            aVar2.eHS.setIsRound(true);
            aVar2.eHS.setClickable(false);
            aVar2.eHT = (TextView) view.findViewById(R.id.fans_name);
            aVar2.eHU = (TextView) view.findViewById(R.id.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.eHS.setTag(null);
                aVar.eHS.setDefaultResource(R.drawable.img_default_100);
                aVar.eHS.startLoad(item.getPortrait(), 12, false);
                aVar.eHS.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.eHT.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.eHU.setText(item.getIntro());
            }
        }
        this.eHR.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eHR.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        HeadImageView eHS;
        TextView eHT;
        TextView eHU;

        private a() {
        }
    }
}
