package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class i implements o {
    CreateGroupStepActivity jsK;
    private int jsO;
    HeadImageView jtk;
    ImageView jtl;
    TextView jtm;
    private com.baidu.adp.widget.ImageView.a jtn = null;
    private a jto = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jsK = null;
        this.mView = null;
        this.jtk = null;
        this.jtl = null;
        this.jtm = null;
        this.jsK = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.jtl = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.jtk = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.jtm = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.jsO = i3;
    }

    public void cGA() {
        if (this.jto != null) {
            this.jto.cancel();
        }
        this.jtn = null;
        this.jto = new a();
        this.jto.execute(new Object[0]);
    }

    public ImageView cGB() {
        return this.jtl;
    }

    public TextView cGC() {
        return this.jtm;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGl() {
        this.jtl.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGm() {
        this.jsK.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jsK.getLayoutMode().onModeChanged(this.mView);
        this.jtk.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.jtk.setVisibility(0);
                i.this.jtn = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.jtn.drawImageTo(i.this.jtk);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jsK.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cGo() {
        if (this.mIndex != this.jsO) {
            return this.jsK.getPageContext().getString(R.string.next_step);
        }
        return this.jsK.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGp() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cGf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGq() {
        return true;
    }
}
