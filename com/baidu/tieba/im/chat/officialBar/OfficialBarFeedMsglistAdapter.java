package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> akG = new ArrayList<>();
    private c kEN;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kEN = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.akG.clear();
            this.akG.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.akG != null && this.akG.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.akG.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.akG == null) {
            return 0;
        }
        return this.akG.size();
    }

    /* loaded from: classes7.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jRl;
        private BarImageView kEP;
        private View kEQ;
        private a kER;

        b(View view) {
            super(view);
            this.kEP = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jRl = (TextView) view.findViewById(R.id.official_bar_name);
            this.kEQ = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kEP.setShowOval(true);
            this.kEP.setPlaceHolder(2);
            this.kEP.setShowOuterBorder(false);
            this.kEP.setShowInnerBorder(true);
            this.kEP.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kER = (a) aVar;
            ap.setViewTextColor(this.jRl, R.color.CAM_X0105);
            ap.setBackgroundResource(this.kEQ, R.drawable.icon_official_bar_red_dot);
            this.kEP.setStrokeColorResId(R.color.CAM_X0401);
            this.kEP.startLoad(this.kER.cVf(), 10, false);
            if (au.getChineseAndEnglishLength(this.kER.cPu()) <= 10) {
                this.jRl.setText(this.kER.cPu());
            } else {
                this.jRl.setText(au.cutChineseAndEnglishWithSuffix(this.kER.cPu(), 8, StringHelper.STRING_MORE));
            }
            this.kEP.setOnClickListener(this);
            if (this.kER.getUnReadCount() > 0 && (this.kER.cVg() <= 0 || System.currentTimeMillis() - this.kER.cVg() < 864000000)) {
                this.kEQ.setVisibility(0);
            } else {
                this.kEQ.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kEQ.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.kEN != null) {
                OfficialBarFeedMsglistAdapter.this.kEN.a(view, this.kER, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long daH;
        private long groupId;
        private String kEO;
        private String kdY;
        private int unReadCount;
        private int userType;

        String cVf() {
            return this.kEO;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cPu() {
            return this.kdY;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Mz(String str) {
            this.kEO = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MA(String str) {
            this.kdY = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cVg() {
            return this.daH;
        }

        public void gP(long j) {
            this.daH = j;
        }
    }
}
