package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dzd;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dxS = false;
        this.dxR = 3;
        this.dxa = new TopicDetaiInputContainer(context);
        this.dzd = ((TopicDetaiInputContainer) this.dxa).getInputView();
        ((TopicDetaiInputContainer) this.dxa).setHint(context.getString(R.string.say_your_point));
        this.dxT = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dzd;
    }
}
